package com.ilmsg.ticket.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class TicketInfo {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String movieName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MM-YYYY")
    private Date movieDate;
    private String movieTime;
    private double ticketPrize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Date movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public double getTicketPrize() {
        return ticketPrize;
    }

    public void setTicketPrize(double ticketPrize) {
        this.ticketPrize = ticketPrize;
    }

    @Override
    public String toString() {
        return "TicketInfo [id=" + id + ", name=" + name + ", email=" + email + ", movieName=" + movieName
                + ", movieDate=" + movieDate + ", movieTime=" + movieTime + ", ticketPrize=" + ticketPrize + "]";
    }
}