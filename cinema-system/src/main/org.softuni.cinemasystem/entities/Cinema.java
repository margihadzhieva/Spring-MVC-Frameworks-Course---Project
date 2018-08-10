package org.softuni.cinemasystem.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cinema")
public class Cinema extends BaseEntity {

    @Column
    private String cinemaName;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String email;

//    @OneToMany(mappedBy = "cinema")
//    private Set<Hall> halls;

    public Cinema() {

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

//    public Set<Hall> getHalls() {
//        return halls;
//    }
//
//    public void setHalls(Set<Hall> halls) {
//        this.halls = halls;
//    }
}



