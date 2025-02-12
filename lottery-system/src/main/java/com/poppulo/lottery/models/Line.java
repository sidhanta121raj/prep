package com.poppulo.lottery.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * @author kalingas
 */
@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private LotteryTicket lotteryTicket;

    private int number1;
    private int number2;
    private int number3;

    private int outcome;
    
    /**
     * Line default Constructor
     */
    public Line() {
    }

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public LotteryTicket getLotteryTicket() {
		return lotteryTicket;
	}

	/**
	 * @param lotteryTicket
	 */
	public void setLotteryTicket(LotteryTicket lotteryTicket) {
		this.lotteryTicket = lotteryTicket;
	}

	/**
	 * @return
	 */
	public int getNumber1() {
		return number1;
	}

	/**
	 * @param number1
	 */
	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	/**
	 * @return
	 */
	public int getNumber2() {
		return number2;
	}

	/**
	 * @param number2
	 */
	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	/**
	 * @return
	 */
	public int getNumber3() {
		return number3;
	}

	/**
	 * @param number3
	 */
	public void setNumber3(int number3) {
		this.number3 = number3;
	}

	/**
	 * @return
	 */
	public int getOutcome() {
		return outcome;
	}

	/**
	 * @param outcome
	 */
	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}

	/**
	 *
	 */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return id != null && id.equals(line.id);
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
}

