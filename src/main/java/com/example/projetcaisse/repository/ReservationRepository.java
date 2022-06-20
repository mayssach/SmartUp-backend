package com.example.projetcaisse.repository;


import com.example.projetcaisse.model.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    List<Reservation> findReservationByProduitIdProduitAndUtilisateurId(Long idProd,Long idUser);
    List<Reservation> findReservationByUtilisateurId(Long id);
    List<Reservation> findReservationByProduitIdProduit(Long idProd);
}
