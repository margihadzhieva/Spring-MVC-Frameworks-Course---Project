package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository  extends JpaRepository<Hall,String> {
}
