package org.softuni.cinemasystem.entities;

import javax.persistence.*;

    @Entity
    @Table(name = "row")
    public class Row extends BaseEntity{


        private Integer rowIndex;


        private int seats;

        private Hall hall;

        public Row() {
        }

        @Column(nullable = false)
        public Integer getRowIndex() {
            return rowIndex;
        }

        public void setRowIndex(Integer rowIndex) {
            this.rowIndex = rowIndex;
        }
        @Column(nullable = false)
        public int getSeats() {
            return seats;
        }

        public void setSeats(int seats) {
            this.seats = seats;
        }

        @ManyToOne
        @JoinColumn(name = "hall_id")
        public Hall getHall() {
            return hall;
        }

        public void setHall(Hall hall) {
            this.hall = hall;
        }
    }


