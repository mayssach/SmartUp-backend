package com.example.projetcaisse.rest.dto;

import com.example.projetcaisse.model.entity.Produit;
import com.example.projetcaisse.model.entity.Utilisateur;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDto {
    private Long idTicket ;
    private float prixTotal ;
    private Date dateCreation ;
    private List<Produit> produits;
    private List<Integer> quantite;
}
