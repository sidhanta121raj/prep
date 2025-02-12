package com.poppulo.lottery.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
import com.poppulo.lottery.testUtil.ReflectionTestUtils;

class LotterySystemServiceImplTests {

    @Mock
    private LotteryTicketRepository lotteryTicketRepository;

    @InjectMocks
    private LotterySystemServiceImpl lotterySystemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        lotterySystemService = new LotterySystemServiceImpl(lotteryTicketRepository);
        ReflectionTestUtils.setField(lotterySystemService, "randomMaxLines", 5); 
    }

    @Test
    void testCreateTicketWithRandomLines() {
        LotteryTicket ticket = new LotteryTicket();
        ticket.setId(1L); // Set the ID field
        when(lotteryTicketRepository.save(any(LotteryTicket.class))).thenReturn(ticket);

        TicketDTO ticketDTO = lotterySystemService.createTicket(null, true);

        assertNotNull(ticketDTO);
        assertEquals(1L, ticketDTO.getId());
    }

    @Test
    void testCreateTicketWithProvidedLines() {
        LotteryTicket ticket = new LotteryTicket();
        ticket.setId(1L); 
        when(lotteryTicketRepository.save(any(LotteryTicket.class))).thenReturn(ticket);

        CreateTicketRequestDTO requestDTO = new CreateTicketRequestDTO();
        List<LineDTO> lines = new ArrayList<>();
        LineDTO lineDTO = new LineDTO();
        lineDTO.setNumber1(0);
        lineDTO.setNumber2(1);
        lineDTO.setNumber3(2);
        lines.add(lineDTO); 
        requestDTO.setLines(lines);

        TicketDTO ticketDTO = lotterySystemService.createTicket(requestDTO, false);

        assertNotNull(ticketDTO);
        assertEquals(1L, ticketDTO.getId());
    }

    @Test
    void testCreateTicketWithoutLinesAndRandomFalse() {
        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            lotterySystemService.createTicket(null, false);
        });

        assertEquals(LotteryConstants.TICKET_CANTBE_CREATED, exception.getMessage());
    }
    
    @Test
    void testGetAllTickets() {
        LotteryTicket ticket = new LotteryTicket();
        ticket.setId(1L); // Set the ID field
        List<LotteryTicket> tickets = new ArrayList<>();
        tickets.add(ticket);
        when(lotteryTicketRepository.findAll()).thenReturn(tickets);

        List<TicketDTO> ticketDTOs = lotterySystemService.getAllTickets();

        assertNotNull(ticketDTOs);
        assertEquals(1L, ticketDTOs.get(0).getId());
    }


    @Test
    void testGetTicketById() {
        LotteryTicket ticket = new LotteryTicket();
        ticket.setId(1L); 
        when(lotteryTicketRepository.findById(1L)).thenReturn(Optional.of(ticket));

        TicketDTO ticketDTO = lotterySystemService.getTicketById(1L);

        assertNotNull(ticketDTO);
        assertEquals(1L, ticketDTO.getId());
    }

    @Test
    void testGetTicketById_NotFound() {
        when(lotteryTicketRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> lotterySystemService.getTicketById(1L));
    }

    @Test
    void testAmendTicketLines() {
        LotteryTicket ticket = new LotteryTicket();
        ticket.setId(1L); 
        when(lotteryTicketRepository.findById(1L)).thenReturn(Optional.of(ticket));
        when(lotteryTicketRepository.save(any(LotteryTicket.class))).thenReturn(ticket);

        CreateTicketRequestDTO requestDTO = new CreateTicketRequestDTO();
        List<LineDTO> lines = new ArrayList<>();
        LineDTO lineDTO = new LineDTO();
        lineDTO.setNumber1(0);
        lineDTO.setNumber2(1);
        lineDTO.setNumber3(2);
        lines.add(lineDTO); 
        requestDTO.setLines(lines);

        TicketDTO ticketDTO = lotterySystemService.amendTicketLines(1L, requestDTO);

        assertNotNull(ticketDTO);
        assertEquals(1L, ticketDTO.getId());
    }

    @Test
    void testAmendTicketLines_CheckedStatus() {
        LotteryTicket ticket = new LotteryTicket();
        ticket.setId(1L); 
        ticket.setStatus(TicketStatus.CHECKED);
        when(lotteryTicketRepository.findById(1L)).thenReturn(Optional.of(ticket));

        CreateTicketRequestDTO requestDTO = new CreateTicketRequestDTO();
        List<LineDTO> lines = new ArrayList<>();
        LineDTO lineDTO = new LineDTO();
        lineDTO.setNumber1(0);
        lineDTO.setNumber2(1);
        lineDTO.setNumber3(2);
        lines.add(lineDTO); 
        requestDTO.setLines(lines);

        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            lotterySystemService.amendTicketLines(1L, requestDTO);
        });

        assertEquals(LotteryConstants.TICKET_CANTBE_AMMENDED, exception.getMessage());
    }
    
    @Test
    void testAmendTicketLines_NotFound() {
        when(lotteryTicketRepository.findById(1L)).thenReturn(Optional.empty());

        CreateTicketRequestDTO requestDTO = new CreateTicketRequestDTO();
        List<LineDTO> lines = new ArrayList<>();
        LineDTO lineDTO = new LineDTO();
        lineDTO.setNumber1(0);
        lineDTO.setNumber2(1);
        lineDTO.setNumber3(2);
        lines.add(lineDTO); 
        requestDTO.setLines(lines);

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            lotterySystemService.amendTicketLines(1L, requestDTO);
        });

        assertEquals(LotteryConstants.TICKET_NOT_FOUND + 1L, exception.getMessage());
    }

    @Test
    void testRetrieveTicketStatus() {
        LotteryTicket ticket = new LotteryTicket();
        ticket.setId(1L); 
        ticket.setStatus(TicketStatus.UNCHECKED);
        List<Line> lines = new ArrayList<>();
        Line line1 = new Line();
        line1.setNumber1(0);
        line1.setNumber2(1);
        line1.setNumber3(1);
        Line line2 = new Line();
        line2.setNumber1(1);
        line2.setNumber2(1);
        line2.setNumber3(1);
        Line line3 = new Line();
        line3.setNumber1(0);
        line3.setNumber2(1);
        line3.setNumber3(2);
        Line line4 = new Line();
        line4.setNumber1(0);
        line4.setNumber2(0);
        line4.setNumber3(1);
        lines.add(line1); 
        lines.add(line2); 
        lines.add(line3); 
        lines.add(line4);
        ticket.setLines(lines);
        when(lotteryTicketRepository.findById(1L)).thenReturn(Optional.of(ticket));
        when(lotteryTicketRepository.save(any(LotteryTicket.class))).thenReturn(ticket);

        TicketDTO ticketDTO = lotterySystemService.retrieveTicketStatus(1L);

        assertNotNull(ticketDTO);
        assertEquals(1L, ticketDTO.getId());
        assertEquals(10, ticketDTO.getLines().get(0).getOutcome());
        assertEquals(5, ticketDTO.getLines().get(1).getOutcome());
        assertEquals(1, ticketDTO.getLines().get(2).getOutcome());
        assertEquals(0, ticketDTO.getLines().get(3).getOutcome());
    }
    
    @Test
    void testRetrieveTicketStatus_CheckedStatus() {
        LotteryTicket ticket = new LotteryTicket();
        ticket.setId(1L); 
        ticket.setStatus(TicketStatus.CHECKED);
        when(lotteryTicketRepository.findById(1L)).thenReturn(Optional.of(ticket));

        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            lotterySystemService.retrieveTicketStatus(1L);
        });

        assertEquals(LotteryConstants.TICKET_ALREADY_CHECKED, exception.getMessage());
    }

    @Test
    void testRetrieveTicketStatus_NotFound() {
        when(lotteryTicketRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> {
            lotterySystemService.retrieveTicketStatus(1L);
        });

        assertEquals(LotteryConstants.TICKET_NOT_FOUND + 1L, exception.getMessage());
    }
}
