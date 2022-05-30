package com.example.projetcaisse.repository;

import com.example.projetcaisse.model.entity.Produit;
import org.springframework.data.repository.CrudRepository;

public interface ProduitRepository extends CrudRepository<Produit,Long> {
}
