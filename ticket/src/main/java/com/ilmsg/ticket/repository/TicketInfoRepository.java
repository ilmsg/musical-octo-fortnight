package com.ilmsg.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilmsg.ticket.entity.TicketInfo;

public interface TicketInfoRepository extends JpaRepository<TicketInfo, Long> {
}