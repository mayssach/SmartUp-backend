package com.example.projetcaisse.rest.controller;

import com.example.projetcaisse.model.entity.Ticket;
import com.example.projetcaisse.rest.dto.TicketDto;
import com.example.projetcaisse.service.ProduitService;
import com.example.projetcaisse.service.TicketService;
import com.example.projetcaisse.service.UtilisateurService;
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
public class TicketController {
    @Autowired
    private ProduitService produitService ;
    @Autowired
    private TicketService ticketService ;
    @Autowired
    private UtilisateurService utilisateurService ;

    @Autowired
    private ModelMapper modelMapper ;
    @GetMapping("/tickets")
    public Object Ticketlist() {
        List<Ticket> tickets= ticketService.getTicketList();
        Type listType = new TypeToken<List<TicketDto>>() {}.getType() ;
        List <TicketDto> ticketDtos= modelMapper.map(tickets,listType);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtos);
    }
    @GetMapping("/tickets/{idTicket}")
    public Object Ticket(@PathVariable Long idTicket ) {
        Ticket ticket = ticketService.getTicket(idTicket) ;
        TicketDto ticketDto= modelMapper.map(ticket, TicketDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDto);
    }

    @PostMapping("/tickets")
    public Object AddTicket(@Validated @RequestBody TicketDto ticketDto)
    {
        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        ticket = ticketService.AddTicket(ticket);
        ticketDto = modelMapper.map(ticket, TicketDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketDto);
    }

    @PutMapping("/tickets/{idTicket}")
    public Object UpdateTicket (@Validated @RequestBody TicketDto ticketDto , @PathVariable Long idTicket) {
        Ticket ticket = modelMapper.map(ticketDto,Ticket.class);
        ticket= ticketService.UpdateTicket(idTicket, ticket);
        ticketDto = modelMapper.map(ticket,TicketDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketDto);

    }

    @DeleteMapping("/tickets/{idTicket}")
    public Object DeleteTicket(@PathVariable Long idTicket) {
        ticketService.DeleteTicket(idTicket);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
