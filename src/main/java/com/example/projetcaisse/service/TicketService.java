package com.example.projetcaisse.service;

import com.example.projetcaisse.model.entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket getTicket(Long id);
    List<Ticket> getTicketList();
    Ticket AddTicket(Ticket ticket);
    Ticket UpdateTicket(Long id,Ticket ticket);
    void DeleteTicket(Long id);
}
