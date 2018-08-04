package org.softuni.cinemasystem.entities;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
class Seat {

        @ManyToOne
        @JoinColumn(name = "row_id")
        private Row row;

        private Integer seat;

    public Seat() {
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}


