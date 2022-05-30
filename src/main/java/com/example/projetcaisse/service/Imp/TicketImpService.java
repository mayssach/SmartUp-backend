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
    public Ticket AddTicket(Ticket ticket) {
        ticket.setDateCreation(new Date());
        Quantite q=new Quantite();
       List<Produit> produits = ticket.getProduits();
       Long idTicket = ticket.getIdTicket();
       Float prixTotal = null;
        if (produits != null) {
            for (Produit produit : produits) {
               q=quantiteService.getQuantite(produit.getIdProduit(),idTicket);
               prixTotal+= q.getQte()* produit.getPrix();
            }
        }
        ticket.setPrixTotal(prixTotal);
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
