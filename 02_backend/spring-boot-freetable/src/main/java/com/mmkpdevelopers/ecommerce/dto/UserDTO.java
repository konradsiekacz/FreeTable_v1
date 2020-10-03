package com.mmkpdevelopers.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Long phoneNumber;
    private String imageUrl;

    public static final class Builder {

        private Long id;
        private String name;
        private String surname;
        private String email;
        private Long phoneNumber;
        private String imageUrl;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.id = this.id;
            userDTO.name = this.name;
            userDTO.surname = this.surname;
            userDTO.email = this.email;
            userDTO.imageUrl = this.imageUrl;
            return userDTO;
        }

    }


}
