package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, String> {
        }


