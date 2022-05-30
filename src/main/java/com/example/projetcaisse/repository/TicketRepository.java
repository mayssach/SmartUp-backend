package com.example.projetcaisse.repository;

import com.example.projetcaisse.model.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket,Long> {
}
