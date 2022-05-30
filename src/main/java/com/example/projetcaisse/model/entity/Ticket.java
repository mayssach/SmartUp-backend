package com.example.projetcaisse.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "TICKET")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket implements Serializable {

    /**
     * generated serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Ticket id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TICK_generator")
    @SequenceGenerator(name = "TICK_generator", sequenceName = "TICK_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "idTicket", updatable = false, nullable = false)
    private Long idTicket ;

    @Column(name="prixTotal")
    private float prixTotal ;

    @Column(name="dateCreation")
    private Date dateCreation ;

    @OneToMany(mappedBy="ticket")
    private List<Quantite> quantites;

    @OneToMany(mappedBy="ticket")
    private List<Produit> produits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    private Utilisateur utilisateur;

}
