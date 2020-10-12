package com.mmkpdevelopers.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String password;

    public static final class Builder {

        private Long id;
        private String username;
        private String email;
        private String password;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }


        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }


        public UserDTO build() {
            UserDTO userDTO = new UserDTO();
            userDTO.id = this.id;
            userDTO.username = this.username;
            userDTO.email = this.email;
            return userDTO;
        }

    }


}
