package com.example.projetcaisse.service;

import com.example.projetcaisse.model.entity.Facture;

import java.util.Date;
import java.util.List;

public interface FactureService {
    Facture getFacture(Long id);
    List<Facture> getFacturesTraite();
    List<Facture> getFacturesEnCour();
    List<Facture> getFactureRecuByClient(Long id);
    List<Facture> getFactureEnCourByClient(Long id);
    List<Facture> getFactureByDates(Date d1, Date d2);
    Facture AddFacture(Facture facture,Long idUser);
    Facture UpdateFacture(Long id,Facture facture);
    void DeleteFacture(Long id);
    Facture activerFacture(Long id);

}
