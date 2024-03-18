package com.ilmsg.ticket.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ilmsg.ticket.dto.MovieTicketAcknowledgement;
import com.ilmsg.ticket.dto.MovieTicketReqeust;
import com.ilmsg.ticket.entity.PaymentInfo;
import com.ilmsg.ticket.entity.TicketInfo;
import com.ilmsg.ticket.repository.PaymentInfoRepository;
import com.ilmsg.ticket.repository.TicketInfoRepository;
import com.ilmsg.ticket.util.ValidatePaymentInfo;

@Service
public class MovieTicketService {
    @Autowired
    private TicketInfoRepository ticketInfoRepository;

    @Autowired
    PaymentInfoRepository paymentInfoRepository;

    @Transactional
    public MovieTicketAcknowledgement bookMovieTicket(MovieTicketReqeust request) {
        TicketInfo newTicketInfo = request.getTicketInfo();
        TicketInfo ticketInfo = ticketInfoRepository.save(newTicketInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        ValidatePaymentInfo.validateCreditLimit(paymentInfo.getAccountNo(), ticketInfo.getTicketPrize());

        paymentInfo.setTicketId(ticketInfo.getId());
        paymentInfo.setAmount(ticketInfo.getTicketPrize());
        paymentInfoRepository.save(paymentInfo);

        return new MovieTicketAcknowledgement(
                "SUCCESS",
                ticketInfo.getTicketPrize(),
                UUID.randomUUID().toString().split("-")[0],
                ticketInfo);
    }

}
