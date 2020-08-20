package com.mmkpdevelopers.freetable.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String adress;
    @OneToMany
    private List<Table> tables;

    public Restaurant() {
    }

    public Restaurant(int id, String name, String adress, List<Table> tables) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.tables = tables;
    }
}
