package com.data.session09.service;
public interface TicketService {
    void bookTicket(Long customerId, Long scheduleId, Long seatId, Double price);
}

