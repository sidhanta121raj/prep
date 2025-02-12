package com.poppulo.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poppulo.lottery.models.LotteryTicket;

/**
 * @author kalingas
 */
@Repository
public interface LotteryTicketRepository extends JpaRepository<LotteryTicket, Long>{

}
