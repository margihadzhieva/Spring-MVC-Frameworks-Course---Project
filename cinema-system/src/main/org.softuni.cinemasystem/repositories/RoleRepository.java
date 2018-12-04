package org.softuni.cinemasystem.repositories;

import org.softuni.cinemasystem.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, String> {
    UserRole getByAuthority(String authority);
}


