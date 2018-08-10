package org.softuni.cinemasystem.models.service;

import org.softuni.cinemasystem.entities.Hall;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Set;

public class CinemaServiceModel {

    private String Id;

    private String cinemaName;

    private String address;

    private String phone;

    private String email;

  //  private Set<String> halls;

    public CinemaServiceModel() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

//    public Set<String> getHalls() {
//        return halls;
//    }
//
//    public void setHalls(Set<String> halls) {
//        this.halls = halls;
//    }
}






