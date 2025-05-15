package com.data.session09.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private Long id;
    private String username;
    private String phone;
    private String address;
    private String gender;
    private String email;

}

