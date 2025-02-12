package com.poppulo.lottery.constant;


/**
 * @author kalingas
 */
public class LotteryConstants {
	
	private LotteryConstants() {
    }
	
	public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 2;
    public static final String NUMBER_NOT_NULL = "Number must not be null";
    public static final String NUMBER_RANGE_MESSAGE = "Number must be between " + MIN_NUMBER + " and " + MAX_NUMBER;
    public static final String TICKET_CANTBE_CREATED = "Tikcet can only be created if Lines have been given or isRandom is True";
    public static final String TICKET_NOT_FOUND = "Ticket not found with id: ";
    public static final String TICKET_CANTBE_AMMENDED = "Ticket lines cannot be amended after checking.";
    public static final String TICKET_ALREADY_CHECKED = "Ticket status has already been checked.";
    

}
