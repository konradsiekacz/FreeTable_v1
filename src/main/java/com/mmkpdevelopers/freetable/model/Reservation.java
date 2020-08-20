package com.mmkpdevelopers.freetable.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private User user; //znaleźć odpowiednie słówko
    @OneToMany
    private List<Table> table;
    @OneToOne
    private Restaurant restaurant;
    private Date dateOfReservation;
    private Date timeOfReservation;

    public Reservation() {
    }

    public Reservation(int id,
                       User user,
                       List<Table> table,
                       Restaurant restaurant,
                       Date dateOfReservation,
                       Date timeOfReservation) {
        this.id = id;
        this.user = user;
        this.table = table;
        this.restaurant = restaurant;
        this.dateOfReservation = dateOfReservation;
        this.timeOfReservation = timeOfReservation;
    }
}
