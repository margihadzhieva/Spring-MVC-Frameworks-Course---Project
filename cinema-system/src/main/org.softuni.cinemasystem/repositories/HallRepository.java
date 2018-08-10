package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository  extends JpaRepository<Hall,String> {
}
