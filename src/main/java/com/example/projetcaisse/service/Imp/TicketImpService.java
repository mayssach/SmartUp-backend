package com.example.projetcaisse.service.Imp;

import com.example.projetcaisse.model.entity.Produit;
import com.example.projetcaisse.model.entity.Quantite;
import com.example.projetcaisse.model.entity.Ticket;
import com.example.projetcaisse.repository.QuantiteRepository;
import com.example.projetcaisse.repository.TicketRepository;
import com.example.projetcaisse.service.ProduitService;
import com.example.projetcaisse.service.QuantiteService;
import com.example.projetcaisse.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TicketImpService implements TicketService {
    @Autowired
    private TicketRepository ticketRepository ;
    @Autowired
    private QuantiteService quantiteService ;
    @Autowired
    private ProduitService produitService ;
    @Override
    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getTicketList() {
        return (List<Ticket>)ticketRepository.findAll();
    }

    @Override
    public Ticket CreerTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket AddTicket(Long idTicket,Ticket ticket) {
        ticket.setDateCreation(new Date());
        List<Quantite> quantites=quantiteService.getQuantiteByTicket(idTicket);
        Float prixTotal = 0f;
        if (quantites != null) {
            for (Quantite quantite : quantites) {
               prixTotal+= quantite.getQte()* quantite.getProduit().getPrix();
            }
        }
        ticket.setPrixTotal(prixTotal);
        ticket.setIdTicket(idTicket);
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
