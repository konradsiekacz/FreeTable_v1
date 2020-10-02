package com.mmkpdevelopers.ecommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Long phoneNumber;
    private String imageUrl;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, String surname, String email, Long phoneNumber, String imageUrl) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
    }
}

