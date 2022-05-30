package com.example.projetcaisse.service;

import com.example.projetcaisse.model.entity.Quantite;

import java.util.List;

public interface QuantiteService {
    Quantite getQuantite(Long idP, Long idT);
    List<Quantite> getQuantiteList();
    Quantite AddQuantite(Quantite quantite);
    Quantite UpdateQuantite(Long id,Quantite quantite);
    void DeleteQuantite(Long id);
}
