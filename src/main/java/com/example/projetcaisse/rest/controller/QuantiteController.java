package com.example.projetcaisse.rest.controller;


import com.example.projetcaisse.model.entity.Produit;
import com.example.projetcaisse.model.entity.Quantite;
import com.example.projetcaisse.model.entity.Ticket;
import com.example.projetcaisse.rest.dto.ProduitDto;
import com.example.projetcaisse.rest.dto.QuantiteDto;
import com.example.projetcaisse.service.ProduitService;
import com.example.projetcaisse.service.QuantiteService;
import com.example.projetcaisse.service.TicketService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@CrossOrigin
public class QuantiteController {
    @Autowired
    private QuantiteService quantiteService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProduitService produitService;
    @Autowired
    private TicketService ticketService;



    @GetMapping("/tickets/{idticket}/produits/{idprod}/Quantites")
    public Object retrieveQuantite(@PathVariable Long idprod,@PathVariable Long idticket) {
        Quantite q = quantiteService.getQuantite(idprod,idticket);
        QuantiteDto quantiteDto = modelMapper.map(q,QuantiteDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(quantiteDto);
    }
    @GetMapping("/tickets/{idticket}/Quantites")
    public Object retrieveQuantiteByTicket(@PathVariable Long idticket) {
        List<Quantite> q = quantiteService.getQuantiteByTicket(idticket);
        Type listType = new TypeToken<List<QuantiteDto>>() {}.getType() ;
        List <QuantiteDto> quantiteDtos= modelMapper.map(q,listType);
        return ResponseEntity.status(HttpStatus.OK).body(quantiteDtos);
    }



    @PostMapping("/tickets/{idticket}/produits/{idprod}/Quantites")
    public Object addQuantite(@PathVariable Long idprod,@PathVariable Long idticket,@Validated @RequestBody QuantiteDto quantiteDto) {
        Quantite quantite = modelMapper.map(quantiteDto,Quantite.class);
        Ticket ticket = ticketService.getTicket(idticket);
        Produit produit = produitService.getProduit(idprod);
        quantite.setTicket(ticket);
        quantite.setProduit(produit);
        quantite = quantiteService.AddQuantite(quantite);
        quantiteDto = modelMapper.map(quantite, QuantiteDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(quantiteDto);
    }

    @DeleteMapping("/Quantites/{idQte}")
    public Object Delete(@PathVariable Long idQte) {
        quantiteService.DeleteQuantite(idQte);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


}
