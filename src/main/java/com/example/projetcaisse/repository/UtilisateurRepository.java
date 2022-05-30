package com.example.projetcaisse.repository;

import com.example.projetcaisse.model.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {
}
