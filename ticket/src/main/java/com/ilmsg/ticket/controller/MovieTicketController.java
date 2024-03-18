package com.ilmsg.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ilmsg.ticket.dto.MovieTicketAcknowledgement;
import com.ilmsg.ticket.dto.MovieTicketReqeust;
import com.ilmsg.ticket.service.MovieTicketService;

@RestController
public class MovieTicketController {
    @Autowired
    private MovieTicketService movieTicketService;

    @PostMapping
    public MovieTicketAcknowledgement bookTicket(@RequestBody MovieTicketReqeust reqeust) {
        return movieTicketService.bookMovieTicket(reqeust);
    }
}