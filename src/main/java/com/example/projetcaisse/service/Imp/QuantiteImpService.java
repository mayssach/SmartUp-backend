package com.example.projetcaisse.service.Imp;

import com.example.projetcaisse.model.entity.Quantite;
import com.example.projetcaisse.model.entity.Ticket;
import com.example.projetcaisse.repository.QuantiteRepository;
import com.example.projetcaisse.repository.TicketRepository;
import com.example.projetcaisse.service.ProduitService;
import com.example.projetcaisse.service.QuantiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuantiteImpService implements QuantiteService {

    @Autowired
    private QuantiteRepository quantiteRepository ;
    @Override
    public Quantite getQuantite(Long idP, Long idT) {
        return quantiteRepository.findQuantiteByProduitIdProduitAndTicketIdTicket(idP,idT);
    }

    @Override
    public List<Quantite> getQuantiteList() {
        return (List<Quantite>)quantiteRepository.findAll();
    }

    @Override
    public Quantite AddQuantite(Quantite quantite) {
        return quantiteRepository.save(quantite);
    }

    @Override
    public Quantite UpdateQuantite(Long id, Quantite quantite) {

        quantite.setIdQte(id);
        return quantiteRepository.save(quantite);
    }

    @Override
    public void DeleteQuantite(Long id) {
        quantiteRepository.deleteById(id);

    }
}
