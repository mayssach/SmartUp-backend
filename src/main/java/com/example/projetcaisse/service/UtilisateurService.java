package com.example.projetcaisse.service;

import com.example.projetcaisse.model.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur getUtilisateur(Long id);
    List<Utilisateur> getUtilisateurList();
    Utilisateur AddUtilisateur(Utilisateur utilisateur);
    Utilisateur UpdateUtilisateur(Long id,Utilisateur utilisateur);
    void DeleteUtilisateur(Long id);
}
