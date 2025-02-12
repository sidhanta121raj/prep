package com.poppulo.lottery.dtos;

import java.util.List;

import jakarta.validation.Valid;

/**
 * @author kalingas
 */
public class CreateTicketRequestDTO {
	@Valid
    private List<LineDTO> lines;

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

	

}
