package com.data.session08.model.Bai8_9_10;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private double balance = 10000;
}
