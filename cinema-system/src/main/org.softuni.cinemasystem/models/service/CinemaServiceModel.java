package org.softuni.cinemasystem.models.service;

import org.softuni.cinemasystem.entities.Hall;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Set;

public class CinemaServiceModel {
   private String id;

    private String cinemaName;


    private String address;


    private String phone;


    private String email;

    public CinemaServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}








