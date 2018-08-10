package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository <Ticket, String> {
}