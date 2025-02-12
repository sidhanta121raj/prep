package com.poppulo.lottery.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.poppulo.lottery.constant.LotteryConstants;
import com.poppulo.lottery.dtos.CreateTicketRequestDTO;
import com.poppulo.lottery.dtos.LineDTO;
import com.poppulo.lottery.dtos.TicketDTO;
import com.poppulo.lottery.exception.BadRequestException;
import com.poppulo.lottery.exception.NotFoundException;
import com.poppulo.lottery.models.Line;
import com.poppulo.lottery.models.LotteryTicket;
import com.poppulo.lottery.models.TicketStatus;
import com.poppulo.lottery.repository.LotteryTicketRepository;
import com.poppulo.lottery.service.LotterySystemService;

@Service
public class LotterySystemServiceImpl implements LotterySystemService {

	private static final Logger log = LoggerFactory.getLogger(LotterySystemServiceImpl.class);

	private LotteryTicketRepository lotteryTicketRepository;

	@Value("${ticket.random.lines.max}")
	private int randomMaxLines;

	@Autowired
	LotterySystemServiceImpl(LotteryTicketRepository lotteryTicketRepository) {
		this.lotteryTicketRepository = lotteryTicketRepository;
	}


	/**
     * Creates a lottery ticket.
     * @param requestDTO the request data transfer object containing lines
     * @param isRandom   flag indicating if the lines should be generated randomly
     * @return the created ticket data transfer object
     */
	@Override
	public TicketDTO createTicket(CreateTicketRequestDTO requestDTO, boolean isRandom) {
		log.debug("Creating ticket with requestDTO: {} and isRandom: {}", requestDTO, isRandom);
		LotteryTicket ticket = new LotteryTicket();
		List<Line> lines = new ArrayList<>();
		if (isRandom) {
			Random random = new Random();
			int numberOfLines = random.nextInt(randomMaxLines) + 1;
			for (int i = 0; i < numberOfLines; i++) {
				Line line = new Line();
				line.setNumber1(random.nextInt(3));
				line.setNumber2(random.nextInt(3));
				line.setNumber3(random.nextInt(3));
				line.setLotteryTicket(ticket);
				lines.add(line);
			}
		} else if (null != requestDTO) {
			List<LineDTO> lineDTOs = requestDTO.getLines();
			for (LineDTO lineDTO : lineDTOs) {
				Line line = new Line();
				line.setNumber1(lineDTO.getNumber1());
				line.setNumber2(lineDTO.getNumber2());
				line.setNumber3(lineDTO.getNumber3());
				line.setLotteryTicket(ticket);
				lines.add(line);
			}
		} else {
			throw new BadRequestException(LotteryConstants.TICKET_CANTBE_CREATED);
		}
		ticket.setLines(lines);
		ticket.setStatus(TicketStatus.UNCHECKED);
		LotteryTicket savedTicket = lotteryTicketRepository.save(ticket);
		log.info("Ticket created successfully with id: {}", savedTicket.getId());
		return mapTicketToDTO(savedTicket, false);
	}


	/**
     * Retrieves all lottery tickets.
     * @return a list of ticket data transfer objects
     */
	@Override
	public List<TicketDTO> getAllTickets() {
		log.debug("Retrieving all tickets");
		List<LotteryTicket> tickets = lotteryTicketRepository.findAll();

		List<TicketDTO> ticketDTOs = mapTicketsToDTOs(tickets, false);
		log.info("Retrieved {} tickets", ticketDTOs.size());

		return ticketDTOs;
	}

	/**
     * Retrieves a lottery ticket by its ID.
     * @param id the ID of the ticket
     * @return the ticket data transfer object
     */
	@Override
	public TicketDTO getTicketById(Long id) {
		log.debug("Retrieving ticket with ID: {}", id);
		LotteryTicket ticket = lotteryTicketRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(LotteryConstants.TICKET_NOT_FOUND + id));

		log.info("Retrieved ticket with ID: {}", id);
		return mapTicketToDTO(ticket, false);
	}

	/**
     * Amends the lines of an existing lottery ticket.
     * @param id the ID of the ticket to amend
     * @param requestDTO the request data transfer object containing new lines
     * @return the amended ticket data transfer object
     */
	@Override
	public TicketDTO amendTicketLines(Long id, CreateTicketRequestDTO requestDTO) {
		log.debug("Amending ticket lines for ticket ID: {} with requestDTO: {}", id, requestDTO);
		LotteryTicket ticket = lotteryTicketRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(LotteryConstants.TICKET_NOT_FOUND + id));

		if (ticket.getStatus() == TicketStatus.CHECKED) {
			throw new BadRequestException(LotteryConstants.TICKET_CANTBE_AMMENDED);
		}

		List<LineDTO> lineDTOs = requestDTO.getLines();
		List<Line> lines = new ArrayList<>();

		for (LineDTO lineDTO : lineDTOs) {
			Line line = new Line();
			line.setNumber1(lineDTO.getNumber1());
			line.setNumber2(lineDTO.getNumber2());
			line.setNumber3(lineDTO.getNumber3());
			line.setLotteryTicket(ticket);
			lines.add(line);
		}

		ticket.getLines().addAll(lines);
		LotteryTicket ammendedTicket = lotteryTicketRepository.save(ticket);
		log.info("Amended ticket lines for ticket ID: {}", id);
		return mapTicketToDTO(ammendedTicket, false);
	}

	/**
     * Retrieves the status of a lottery ticket.
     * @param id the ID of the ticket
     * @return the ticket data transfer object with status
     */
	@Override
	public TicketDTO retrieveTicketStatus(Long id) {
		log.debug("Retrieving ticket status for ticket ID: {}", id);
		LotteryTicket ticket = lotteryTicketRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(LotteryConstants.TICKET_NOT_FOUND + id));

		if (ticket.getStatus() == TicketStatus.CHECKED) {
			throw new BadRequestException(LotteryConstants.TICKET_ALREADY_CHECKED);
		}

		List<Line> lines = ticket.getLines();

		for (Line line : lines) {
			int sum = line.getNumber1() + line.getNumber2() + line.getNumber3();

			if (sum == 2) {
				line.setOutcome(10);
			} else if (line.getNumber1() == line.getNumber2() && line.getNumber2() == line.getNumber3()) {
				line.setOutcome(5);
			} else if (line.getNumber1() != line.getNumber2() && line.getNumber1() != line.getNumber3()) {
				line.setOutcome(1);
			} else {
				line.setOutcome(0);
			}
		}

		ticket.setStatus(TicketStatus.CHECKED);
		LotteryTicket savedTicket = lotteryTicketRepository.save(ticket);

		TicketDTO ticketDTO = mapTicketToDTO(savedTicket, true);
		ticketDTO.getLines().sort(Comparator.comparingInt((LineDTO l) -> l.getOutcome()).reversed());

		log.info("Retrieved ticket status for ticket ID: {}", id);
		return ticketDTO;
	}

	/**
     * Maps a list of LotteryTicket objects to a list of TicketDTO objects.
     * @param tickets the list of LotteryTicket objects
     * @param shouldIncludeOutcome flag indicating if the outcome should be included
     * @return a list of TicketDTO objects
     */
	private List<TicketDTO> mapTicketsToDTOs(List<LotteryTicket> tickets, boolean shouldIncludeOutcome) {
		List<TicketDTO> ticketDTOs = new ArrayList<>();

		for (LotteryTicket ticket : tickets) {
			TicketDTO ticketDTO = mapTicketToDTO(ticket, shouldIncludeOutcome);
			ticketDTOs.add(ticketDTO);
		}

		return ticketDTOs;
	}

	/**
     * Maps a LotteryTicket object to a TicketDTO object.
     * @param ticket the LotteryTicket object
     * @param shouldIncludeOutcome flag indicating if the outcome should be included
     * @return the TicketDTO object
     */
	private TicketDTO mapTicketToDTO(LotteryTicket ticket, boolean shouldIncludeOutcome) {
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setId(ticket.getId());
		ticketDTO.setLines(mapLinesToDTOs(ticket.getLines(), shouldIncludeOutcome));
		ticketDTO.setStatus(ticket.getStatus());
		return ticketDTO;
	}

	/**
     * Maps a list of Line objects to a list of LineDTO objects.
     * @param lines the list of Line objects
     * @param shouldIncludeOutcome flag indicating if the outcome should be included
     * @return a list of LineDTO objects
     */
	private List<LineDTO> mapLinesToDTOs(List<Line> lines, boolean shouldIncludeOutcome) {
		List<LineDTO> lineDTOs = new ArrayList<>();

		for (Line line : lines) {
			LineDTO lineDTO = new LineDTO();
			lineDTO.setNumber1(line.getNumber1());
			lineDTO.setNumber2(line.getNumber2());
			lineDTO.setNumber3(line.getNumber3());
			if (shouldIncludeOutcome) {
				lineDTO.setOutcome(line.getOutcome());
			} else {
				lineDTO.setOutcome(null);
			}
			lineDTOs.add(lineDTO);
		}

		return lineDTOs;
	}

}
