package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
