package com.example.projetcaisse.service;

import com.example.projetcaisse.model.entity.Reclamation;
import com.example.projetcaisse.model.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation getReservation(Long id);
    List<Reservation> getReservationListParUser(Long idUser);
    List<Reservation> getReservationL();
    List<Reservation> getReservationList(Long idProd,Long idUser);
    List<Reservation> getReservationListParProduit(Long idProd);
    Reservation AddReservation(Reservation reservation,Long idP);
    Reservation UpdateReservation(Long id,Reservation reservation,Long idProd);
    void DeleteReservation(Long id);
}
