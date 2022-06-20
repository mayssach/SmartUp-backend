package com.example.projetcaisse.service.Imp;

import com.example.projetcaisse.model.entity.Facture;
import com.example.projetcaisse.model.entity.Produit;
import com.example.projetcaisse.model.entity.Reservation;
import com.example.projetcaisse.model.entity.Utilisateur;
import com.example.projetcaisse.repository.FactureRepository;
import com.example.projetcaisse.repository.ProduitRepository;
import com.example.projetcaisse.repository.ReservationRepository;
import com.example.projetcaisse.service.FactureService;
import com.example.projetcaisse.service.ProduitService;
import com.example.projetcaisse.service.ReservationService;
import com.example.projetcaisse.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FactureImpService implements FactureService {

    @Autowired
    private FactureRepository repository ;
    @Autowired
    private ReservationService reservationService ;
    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public Facture getFacture(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Facture> getFacturesTraite() {
        return (List<Facture>) repository.findFactureByActive(1);
    }
    @Override
    public List<Facture> getFacturesEnCour() {
        return (List<Facture>) repository.findFactureByActive(0);
    }

    @Override
    public List<Facture> getFactureRecuByClient(Long id) {
        return (List<Facture>) repository.findFactureByIdUserAndActive(id,1);
    }
    @Override
    public List<Facture> getFactureEnCourByClient(Long id) {
        return (List<Facture>) repository.findFactureByIdUserAndActive(id,0);
    }

    @Override
    public List<Facture> getFactureByDates(Date d1, Date d2) {
        return (List<Facture>) repository.findFactureByDateAjoutBetween(d1,d2);    }

    @Override
    public Facture AddFacture(Facture facture,Long idUser) {
        facture.setIdUser(idUser);
        Utilisateur u =utilisateurService.getUtilisateur(idUser);
        facture.setUsername(u.getUsername());
        facture.setAdresse(u.getAdresse());
        facture.setTelephone(u.getTelephone());
        facture.setReservations(reservationService.getReservationListParUser(idUser));
        List<Reservation> reservations = facture.getReservations();
        if (reservations != null) {
            for (Reservation reservation : reservations) {
                facture.setPrixSansTVA(facture.getPrixSansTVA()+ (reservation.getPrix()* reservation.getQte()));
                reservationService.DeleteReservation(reservation.getIdReservation());
            }
        }
        facture.setPrixUnitaire(facture.getPrixSansTVA()+facture.getTva());
        return repository.save(facture);
    }

    @Override
    public Facture UpdateFacture(Long id, Facture facture) {
        return null;
    }

    @Override
    public void DeleteFacture(Long id) {
         repository.deleteById(id);
    }

    @Override
    public Facture activerFacture(Long id) {
        Facture f=repository.findById(id).get();
        f.setActive(1);
        return repository.save(f);    }


}
