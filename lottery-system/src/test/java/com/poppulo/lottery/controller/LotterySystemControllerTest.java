package com.poppulo.lottery.controller;

import com.poppulo.lottery.dtos.CreateTicketRequestDTO;
import com.poppulo.lottery.dtos.TicketDTO;
import com.poppulo.lottery.service.LotterySystemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LotterySystemController.class)
class LotterySystemControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private LotterySystemService lotterySystemService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void testCreateTicket() throws Exception {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(1L); 
        when(lotterySystemService.createTicket(any(CreateTicketRequestDTO.class), any(Boolean.class)))
                .thenReturn(ticketDTO);

        mockMvc.perform(post("/lottery/v1/ticket")
                .param("isRandom", "true")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void testGetAllTickets() throws Exception {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(1L); 
        when(lotterySystemService.getAllTickets()).thenReturn(Collections.singletonList(ticketDTO));

        mockMvc.perform(get("/lottery/v1/ticket"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1L));
    }

    @Test
    void testGetTicketById() throws Exception {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(1L); 
        when(lotterySystemService.getTicketById(1L)).thenReturn(ticketDTO);

        mockMvc.perform(get("/lottery/v1/ticket/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void testAmendTicketLines() throws Exception {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(1L); 
        when(lotterySystemService.amendTicketLines(any(Long.class), any(CreateTicketRequestDTO.class)))
                .thenReturn(ticketDTO);

        mockMvc.perform(put("/lottery/v1/ticket/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void testRetrieveTicketStatus() throws Exception {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(1L); 
        when(lotterySystemService.retrieveTicketStatus(1L)).thenReturn(ticketDTO);

        mockMvc.perform(put("/lottery/v1/ticket/status/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }
}
