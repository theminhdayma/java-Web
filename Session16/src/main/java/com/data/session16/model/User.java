package com.data.session16.model;

import lombok.*;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private Role role;
    private Status status;
}
