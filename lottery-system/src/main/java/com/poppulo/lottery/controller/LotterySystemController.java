package com.poppulo.lottery.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.poppulo.lottery.dtos.CreateTicketRequestDTO;
import com.poppulo.lottery.dtos.TicketDTO;
import com.poppulo.lottery.service.LotterySystemService;
import com.poppulo.lottery.views.Views;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * @author kalingas
 */
@RestController
@RequestMapping("lottery/v1/ticket")
@Validated
public class LotterySystemController {
	private static final Logger log = LoggerFactory.getLogger(LotterySystemController.class);
	
	private final LotterySystemService lotterySystemService;
	
	@Autowired
	public LotterySystemController(LotterySystemService lotterySystemService) {
		this.lotterySystemService = lotterySystemService;
	}
	

	/**
	 * Create a new lottery ticket
	 * @param isRandom
	 * @param requestDTO
	 * @return
	 */
	@Operation(summary = "Create a new lottery ticket")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Ticket created",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = TicketDTO.class)) }),
        @ApiResponse(responseCode = "400", description = "Invalid input",
            content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content) })
	@JsonView(Views.Public.class)
	@PostMapping
	public ResponseEntity<TicketDTO> createTicket(@RequestParam(value = "isRandom", defaultValue = "true") boolean isRandom,
            @Valid @RequestBody(required = false) CreateTicketRequestDTO requestDTO) {
		log.debug("Received request to create ticket with isRandom: {} and requestDTO: {}", isRandom, requestDTO);
        
		TicketDTO ticket = lotterySystemService.createTicket(requestDTO, isRandom);
		
		log.info("Created ticket with ID: {}", ticket.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
    }


	/**
	 * Get all lottery tickets
	 * @return
	 */
	@Operation(summary = "Get all lottery tickets")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found all tickets",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = TicketDTO.class)) }),
        @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content) })
	@JsonView(Views.Public.class)
	@GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
		log.debug("Received request to get all tickets");
		
        List<TicketDTO> tickets = lotterySystemService.getAllTickets();
        
        log.info("Retrieved {} tickets", tickets.size());
        return ResponseEntity.ok(tickets);
    }



	/**
	 * Get a lottery ticket by ID
	 * @param id
	 * @return
	 */
	@Operation(summary = "Get a lottery ticket by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the ticket",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = TicketDTO.class)) }),
        @ApiResponse(responseCode = "404", description = "Ticket not found",
            content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content) })
	@JsonView(Views.Public.class)
	@GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id) {
		log.debug("Received request to get ticket by ID: {}", id);
		
        TicketDTO ticket = lotterySystemService.getTicketById(id);
        
        log.info("Retrieved ticket with ID: {}", id);
        return ResponseEntity.ok(ticket);
    }


	/**
	 * Amend lines of a lottery ticket
	 * @param id
	 * @param requestDTO
	 * @return
	 */
	@Operation(summary = "Amend lines of a lottery ticket")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ticket amended",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = TicketDTO.class)) }),
        @ApiResponse(responseCode = "404", description = "Ticket not found",
            content = @Content),
        @ApiResponse(responseCode = "400", description = "Invalid input",
            content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content) })
	@JsonView(Views.Public.class)
	@PutMapping("/{id}")
    public ResponseEntity<TicketDTO> amendTicketLines(@PathVariable Long id, @Valid @RequestBody CreateTicketRequestDTO requestDTO) {
		log.debug("Received request to amend ticket lines for ticket ID: {} with requestDTO: {}", id, requestDTO);
		
    	TicketDTO ticket = lotterySystemService.amendTicketLines(id, requestDTO);
    	
    	log.info("Amended ticket lines for ticket ID: {}", id);
        return ResponseEntity.ok(ticket);
    }


	/**
	 * Retrieve the status of a lottery ticket
	 * @param id
	 * @return
	 */
	@Operation(summary = "Retrieve the status of a lottery ticket")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status retrieved",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = TicketDTO.class)) }),
        @ApiResponse(responseCode = "404", description = "Ticket not found",
            content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error",
            content = @Content) })
	@JsonView(Views.Internal.class)
	@PutMapping("/status/{id}")
    public ResponseEntity<TicketDTO> retrieveTicketStatus(@PathVariable Long id) {
		log.debug("Received request to retrieve ticket status for ticket ID: {}", id);
        
    	TicketDTO ticket = lotterySystemService.retrieveTicketStatus(id);
    	
    	log.info("Retrieved ticket status for ticket ID: {}", id);
        return ResponseEntity.ok(ticket);
    }

}
