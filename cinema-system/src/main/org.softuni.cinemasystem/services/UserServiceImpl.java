package org.softuni.cinemasystem.services;

import org.modelmapper.ModelMapper;
import org.softuni.cinemasystem.entities.UserRole;
import org.softuni.cinemasystem.models.service.UserServiceModel;
import org.softuni.cinemasystem.repositories.RoleRepository;
import org.softuni.cinemasystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.softuni.cinemasystem.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService  {
   private final UserRepository userRepository;
   private final RoleRepository roleRepository;
   private final ModelMapper modelMapper;
   private final BCryptPasswordEncoder bCryptPasswordEncoder;

   @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
       this.roleRepository = roleRepository;
       this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    private Set<UserRole> getAuthorities(String authority) {
        Set<UserRole> userAuthorities = new HashSet<>();

        userAuthorities.add(this.roleRepository.getByAuthority(authority));

        return userAuthorities;
    }
    @Override
    public boolean createUser(UserServiceModel userServiceModel) {
        User userEntity = this.modelMapper.map(userServiceModel,User.class);

        userEntity.setPassword(this.bCryptPasswordEncoder.encode(userEntity.getPassword()));

        if(this.userRepository.findAll().isEmpty()) {
            userEntity.setAuthorities(this.getAuthorities("USER"));
        } else {
            userEntity.setAuthorities(this.getAuthorities("USER"));
        }

        try {
            this.userRepository.save(userEntity);
        } catch (Exception ignored) {
            //TODO: Fix this when discover exception type.
            return false;
        }

        return true;
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository
                .findByUsername(username)
                .orElse(null);

        if(user == null) throw new UsernameNotFoundException("No such user.");

        return user;
    }


}
