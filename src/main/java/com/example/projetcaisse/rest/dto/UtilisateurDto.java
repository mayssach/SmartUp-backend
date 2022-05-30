package com.example.projetcaisse.rest.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtilisateurDto {
    private Long idUser ;
    private String cin ;
    private String nom ;
    private String prenom ;
    private String dateNais ;
    private String email ;
    private String login ;
    private String password ;
    private int active ;
}
