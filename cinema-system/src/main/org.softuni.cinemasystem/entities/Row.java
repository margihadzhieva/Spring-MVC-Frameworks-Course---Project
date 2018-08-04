package org.softuni.cinemasystem.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "row")
public class Row extends BaseEntity{

    @Column(nullable = false)
    private Integer rowIndex;

    @Column(nullable = false)
    private int seats;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    public Row() {
    }


    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }
}
