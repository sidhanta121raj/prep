package com.poppulo.lottery.models;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



/**
 * @author kalingas
 */
@Entity
public class LotteryTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "lotteryTicket", cascade = CascadeType.ALL)
    private List<Line> lines = new ArrayList<>();
    
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    
    /**
     * LotteryTicket default constructor
     */
    public LotteryTicket() {
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
	public List<Line> getLines() {
		return lines;
	}

	/**
	 * @param lines
	 */
	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	/**
	 * @return
	 */
	public TicketStatus getStatus() {
		return ticketStatus;
	}
	/**
	 * @param checked
	 */
	public void setStatus(TicketStatus checked) {
		this.ticketStatus = checked;
		
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return "LotteryTicket [id=" + id + ", lines=" + lines + ", ticketStatus=" + ticketStatus + "]";
	}
	
	/**
	 * equals method
	 */
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryTicket that = (LotteryTicket) o;
        return id != null && id.equals(that.id);
    }

    /**
     * hashCode method
     */
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
	
	

	

    
}
