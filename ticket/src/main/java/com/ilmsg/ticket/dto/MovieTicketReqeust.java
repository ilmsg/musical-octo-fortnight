package com.ilmsg.ticket.dto;

import com.ilmsg.ticket.entity.PaymentInfo;
import com.ilmsg.ticket.entity.TicketInfo;

public class MovieTicketReqeust {
    private TicketInfo ticketInfo;
    private PaymentInfo paymentInfo;

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public String toString() {
        return "MovieTicketReqeust [ticketInfo=" + ticketInfo + ", paymentInfo=" + paymentInfo + "]";
    }
}