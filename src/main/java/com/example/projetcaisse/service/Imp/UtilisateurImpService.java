package com.example.projetcaisse.service.Imp;

import com.example.projetcaisse.model.entity.Utilisateur;
import com.example.projetcaisse.repository.UtilisateurRepository;
import com.example.projetcaisse.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurImpService implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository ;
    @Override
    public Utilisateur getUtilisateur(Long id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public List<Utilisateur> getUtilisateurList() {
        return (List<Utilisateur>)utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur AddUtilisateur(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    @Override
    public Utilisateur UpdateUtilisateur(Long id, Utilisateur utilisateur) {
        getUtilisateur(id);
        utilisateur.setIdUser(id);
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void DeleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}