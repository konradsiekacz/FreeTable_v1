package com.mmkpdevelopers.freetable.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@javax.persistence.Table(name = "tables")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int tableNumber;
    @Column
    private int numberOfSeats;

    public Table() {
    }

    public Table(int tableNumber, int numberOfSeats) {
        this.tableNumber = tableNumber;
        this.numberOfSeats = numberOfSeats;
    }
}
