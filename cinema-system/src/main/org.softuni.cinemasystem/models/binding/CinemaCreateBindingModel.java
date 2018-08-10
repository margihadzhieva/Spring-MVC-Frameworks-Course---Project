package org.softuni.cinemasystem.models.binding;

import org.softuni.cinemasystem.entities.Hall;

import java.util.Set;

public class CinemaCreateBindingModel {

    private String cinemaName;

    private String address;

    private String phone;

    private String email;

//    private Set<String> halls;

    public CinemaCreateBindingModel(String cinemaName, String address, String phone, String email, Set<String> halls) {
        this.cinemaName = cinemaName;
        this.address = address;
        this.phone = phone;
        this.email = email;
       // this.halls = halls;
    }

    public CinemaCreateBindingModel() {

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
