package com.poppulo.lottery.service;

import java.util.List;

import com.poppulo.lottery.dtos.CreateTicketRequestDTO;
import com.poppulo.lottery.dtos.TicketDTO;

/**
 * @author kalingas
 */
public interface LotterySystemService {

	TicketDTO createTicket(CreateTicketRequestDTO requestDTO, boolean isRandom);

	List<TicketDTO> getAllTickets();

	TicketDTO getTicketById(Long id);

	TicketDTO amendTicketLines(Long id, CreateTicketRequestDTO requestDTO);

	TicketDTO retrieveTicketStatus(Long id);
	
	

}
