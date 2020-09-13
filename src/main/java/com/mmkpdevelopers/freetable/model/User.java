package com.mmkpdevelopers.freetable.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private int phoneNumber;

    public User() {
    }

    public User(String firstName, String surname, String email, int phoneNumber) {
        this.firstName= firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
