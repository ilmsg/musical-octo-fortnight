package com.ilmsg.ticket.dto;

import com.ilmsg.ticket.entity.TicketInfo;

public class MovieTicketAcknowledgement {
    private String status;
    private double totalFare;
    private String prnNo;
    private TicketInfo ticketInfo;

    public MovieTicketAcknowledgement(String status, double totalFare, String prnNo, TicketInfo ticketInfo) {
        this.status = status;
        this.totalFare = totalFare;
        this.prnNo = prnNo;
        this.ticketInfo = ticketInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public String getPrnNo() {
        return prnNo;
    }

    public void setPrnNo(String prnNo) {
        this.prnNo = prnNo;
    }

    public TicketInfo getTicketInfo() {
        return ticketInfo;
    }

    public void setTicketInfo(TicketInfo ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    @Override
    public String toString() {
        return "MovieTicketAcknowledgement [status=" + status + ", totalFare=" + totalFare + ", prnNo=" + prnNo
                + ", ticketInfo=" + ticketInfo + "]";
    }

}