package com.example.projetcaisse.repository;

import com.example.projetcaisse.model.entity.Quantite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuantiteRepository extends CrudRepository<Quantite,Long> {
    Quantite findQuantiteByProduitIdProduitAndTicketIdTicket(Long idProd,Long idTicket);
    List<Quantite> findQuantiteByTicketIdTicket(Long idTicket);
}
