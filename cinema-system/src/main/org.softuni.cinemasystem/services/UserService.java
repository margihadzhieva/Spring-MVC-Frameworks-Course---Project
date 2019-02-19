package org.softuni.cinemasystem.services;

import org.softuni.cinemasystem.models.service.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    boolean createUser(UserServiceModel userServiceModel);

}
