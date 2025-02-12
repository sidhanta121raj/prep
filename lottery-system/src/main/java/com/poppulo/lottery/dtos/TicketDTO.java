package com.poppulo.lottery.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.poppulo.lottery.models.TicketStatus;
import com.poppulo.lottery.views.Views;

/**
 * @author kalingas
 */
public class TicketDTO {
	@JsonView(Views.Public.class)
	private Long id;
	
	@JsonView(Views.Public.class)
    private List<LineDTO> lines;
	
	@JsonView(Views.Public.class)
    private TicketStatus status;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the lines
	 */
	public List<LineDTO> getLines() {
		return lines;
	}

	/**
	 * @param lines the lines to set
	 */
	public void setLines(List<LineDTO> lines) {
		this.lines = lines;
	}

	/**
	 * @return the status
	 */
	public TicketStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	

}
