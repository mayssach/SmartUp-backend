package com.example.projetcaisse.rest.controller;

import com.example.projetcaisse.model.entity.Facture;
import com.example.projetcaisse.model.entity.Produit;
import com.example.projetcaisse.rest.dto.FactureDto;
import com.example.projetcaisse.rest.dto.ProduitDto;
import com.example.projetcaisse.service.FactureService;
import com.example.projetcaisse.service.ProduitService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class FactureController {
    @Autowired
    private FactureService service ;
    @Autowired
    private ModelMapper modelMapper ;

    @GetMapping("/date1/{d1}/date2/{d2}/factures")
    public Object Facturelist(@PathVariable Date d1,@PathVariable Date d2) {
        List<Facture> factures= service.getFactureByDates(d1,d2);
        Type listType = new TypeToken<List<FactureDto>>() {}.getType() ;
        List <FactureDto> factureDtos= modelMapper.map(factures,listType);
        return ResponseEntity.status(HttpStatus.OK).body(factureDtos);
    }

    @GetMapping("/facturesEnCour")
    public Object FacturelistEnCour() {
        List<Facture> factures= service.getFacturesEnCour();
        Type listType = new TypeToken<List<FactureDto>>() {}.getType() ;
        List <FactureDto> factureDtos= modelMapper.map(factures,listType);
        return ResponseEntity.status(HttpStatus.OK).body(factureDtos);
    }
    @GetMapping("/facturesTraites")
    public Object FacturelistTraites() {
        List<Facture> factures= service.getFacturesTraite();
        Type listType = new TypeToken<List<FactureDto>>() {}.getType() ;
        List <FactureDto> factureDtos= modelMapper.map(factures,listType);
        return ResponseEntity.status(HttpStatus.OK).body(factureDtos);
    }

    @GetMapping("/utilisateur/{idUser}/facturesTraites")
    public Object FacturelistTraitesByClient(@PathVariable Long idUser) {
        List<Facture> factures= service.getFactureRecuByClient(idUser);
        Type listType = new TypeToken<List<FactureDto>>() {}.getType() ;
        List <FactureDto> factureDtos= modelMapper.map(factures,listType);
        return ResponseEntity.status(HttpStatus.OK).body(factureDtos);
    }
    @GetMapping("/utilisateur/{idUser}/facturesNonTraites")
    public Object FacturelistNonRecuByClient(@PathVariable Long idUser) {
        List<Facture> factures= service.getFactureEnCourByClient(idUser);
        Type listType = new TypeToken<List<FactureDto>>() {}.getType() ;
        List <FactureDto> factureDtos= modelMapper.map(factures,listType);
        return ResponseEntity.status(HttpStatus.OK).body(factureDtos);
    }


    @GetMapping("/facture/{idfac}")
    public Object Facture(@PathVariable Long idfac ) {
        Facture facture = service.getFacture(idfac) ;
        FactureDto factureDto= modelMapper.map(facture, FactureDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(factureDto);
    }

    @PostMapping("/client/{idUser}/facture")
    public Object AddFacture(@Validated @RequestBody FactureDto factureDto,@PathVariable Long idUser)
    {
        Facture facture = modelMapper.map(factureDto, Facture.class);
        facture = service.AddFacture(facture,idUser);
        factureDto = modelMapper.map(facture, FactureDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(factureDto);
    }

    @PutMapping("/facture/{id}")
    public Object UpdateFacture (@Validated @RequestBody FactureDto factureDto , @PathVariable Long id) {
        Facture facture = modelMapper.map(factureDto, Facture.class);
        facture= service.UpdateFacture(id, facture);
        factureDto = modelMapper.map(facture,FactureDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(factureDto);

    }

    @PutMapping("/facturesTraites/{idFac}")
    public Object ActiverFacture (@Validated @RequestBody FactureDto factureDto , @PathVariable Long idFac) {
        Facture facture = modelMapper.map(factureDto, Facture.class);
        facture= service.activerFacture(idFac);
        factureDto = modelMapper.map(facture,FactureDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(factureDto);

    }

    @DeleteMapping("/facture/{idFac}")
    public Object DeleteFacture(@PathVariable Long idFac) {
        service.DeleteFacture(idFac);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}

