package com.mmkpdevelopers.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private Long phoneNumber;

    @Column(name = "imageurl")
    private String imageUrl;
}
