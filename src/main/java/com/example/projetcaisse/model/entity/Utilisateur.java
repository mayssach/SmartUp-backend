package com.example.projetcaisse.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "UTILISATEUR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur implements Serializable {

    /**
     * generated serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * User id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usr_generator")
    @SequenceGenerator(name = "usr_generator", sequenceName = "usr_SEQ", initialValue = 1, allocationSize = 1)
    @Column(name = "idUser", updatable = false, nullable = false)
    private Long idUser ;

    @Column(name="cin")
    private String cin ;

    @Column(name="nom")
    private String nom ;

    @Column(name="prenom")
    private String prenom ;

    @Column(name="dateNais")
    private String dateNais ;

    @Column(name="email")
    private String email ;

    @Column(name="login")
    private String login ;

    @Column(name="password")
    private String password ;

    @Column(name="active")
    private int active ;

    @OneToMany(mappedBy="utilisateur")
    private List<Ticket> tickets;

}

