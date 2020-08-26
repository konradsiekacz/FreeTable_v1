package com.mmkpdevelopers.freetable.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String adress;
    @OneToMany
    private List<Table> tables;

    public Restaurant() {
    }

    public Restaurant(String name, String adress, List<Table> tables) {
        this.name = name;
        this.adress = adress;
        this.tables = tables;
    }
}
