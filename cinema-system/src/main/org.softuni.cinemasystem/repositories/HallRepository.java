package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository  extends JpaRepository<Hall,String> {

    @Query(value = "SELECT * FROM hall WHERE cinema_id = :cinemaId"
            , nativeQuery = true)
    List<Hall> findAllByCinemaId(@Param("cinemaId") String cinemaId);

}
