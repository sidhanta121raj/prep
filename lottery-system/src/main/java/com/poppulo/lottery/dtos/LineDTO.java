package com.poppulo.lottery.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.poppulo.lottery.constant.LotteryConstants;
import com.poppulo.lottery.views.Views;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * @author kalingas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineDTO {
	
	@NotNull(message=LotteryConstants.NUMBER_NOT_NULL)
	@Min(value = LotteryConstants.MIN_NUMBER, message = LotteryConstants.NUMBER_RANGE_MESSAGE)
    @Max(value = LotteryConstants.MAX_NUMBER, message = LotteryConstants.NUMBER_RANGE_MESSAGE)
	@JsonView(Views.Public.class)
	private Integer number1;
	

	@NotNull(message=LotteryConstants.NUMBER_NOT_NULL)
	@Min(value = LotteryConstants.MIN_NUMBER, message = LotteryConstants.NUMBER_RANGE_MESSAGE)
    @Max(value = LotteryConstants.MAX_NUMBER, message = LotteryConstants.NUMBER_RANGE_MESSAGE)
	@JsonView(Views.Public.class)
    private Integer number2;
	

	@NotNull(message=LotteryConstants.NUMBER_NOT_NULL)
	@Min(value = LotteryConstants.MIN_NUMBER, message = LotteryConstants.NUMBER_RANGE_MESSAGE)
    @Max(value = LotteryConstants.MAX_NUMBER, message = LotteryConstants.NUMBER_RANGE_MESSAGE)
	@JsonView(Views.Public.class)
    private Integer number3;
	
	@JsonView(Views.Internal.class)
    private Integer outcome;
    

	/**
	 * @return the number1
	 */
	public Integer getNumber1() {
		return number1;
	}

	/**
	 * @param number1 the number1 to set
	 */
	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	/**
	 * @return the number2
	 */
	public Integer getNumber2() {
		return number2;
	}

	/**
	 * @param number2 the number2 to set
	 */
	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	/**
	 * @return the number3
	 */
	public Integer getNumber3() {
		return number3;
	}

	/**
	 * @param number3 the number3 to set
	 */
	public void setNumber3(Integer number3) {
		this.number3 = number3;
	}

	/**
	 * @return the outcome
	 */
	public Integer getOutcome() {
		return outcome;
	}

	/**
	 * @param outcome the outcome to set
	 */
	public void setOutcome(Integer outcome) {
		this.outcome = outcome;
	}
	
    

}
