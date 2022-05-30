package com.example.projetcaisse.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "QUANTITE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quantite implements Serializable {
    /**
     * generated serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Ticket id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QNT_generator")
    @SequenceGenerator(name = "QNT_generator", sequenceName = "QNT_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "idQte", updatable = false, nullable = false)
    private Long idQte ;

    @Column(name="qte")
    private int qte ;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduit")
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTicket")
    private Ticket ticket;



}
