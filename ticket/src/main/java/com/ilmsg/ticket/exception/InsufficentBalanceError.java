package com.ilmsg.ticket.exception;

public class InsufficentBalanceError extends RuntimeException {
    public InsufficentBalanceError(String message) {
        super(message);
    }
}
