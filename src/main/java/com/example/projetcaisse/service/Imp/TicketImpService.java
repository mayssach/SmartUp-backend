package com.example.projetcaisse.service.Imp;

import com.example.projetcaisse.model.entity.Ticket;
import com.example.projetcaisse.repository.TicketRepository;
import com.example.projetcaisse.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TicketImpService implements TicketService {
    @Autowired
    private TicketRepository ticketRepository ;
    @Override
    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getTicketList() {
        return (List<Ticket>)ticketRepository.findAll();
    }

    @Override
    public Ticket AddTicket(Ticket ticket) {
        ticket.setDateCreation(new Date());
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket UpdateTicket(Long id, Ticket ticket) {
        getTicket(id);
        ticket.setIdTicket(id);
        return ticketRepository.save(ticket);
    }

    @Override
    public void DeleteTicket(Long id) {
        ticketRepository.deleteById(id);

    }
}
