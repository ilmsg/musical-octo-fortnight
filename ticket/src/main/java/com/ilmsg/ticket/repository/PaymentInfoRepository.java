package com.ilmsg.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilmsg.ticket.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}