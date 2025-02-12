package com.poppulo.lottery.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.poppulo.lottery.models.LotteryTicket;

@DataJpaTest
public class LotteryTicketRepositoryTest {
	@Autowired
    private LotteryTicketRepository ticketRepository;

    @Test
    public void testFindAll() {
    	LotteryTicket ticket = new LotteryTicket();
        // Set properties of ticket as needed
        ticketRepository.save(ticket);

        List<LotteryTicket> tickets = ticketRepository.findAll();

        assertEquals(1, tickets.size());
        assertEquals(ticket, tickets.get(0));
    }

    // Add more tests for other methods

}
