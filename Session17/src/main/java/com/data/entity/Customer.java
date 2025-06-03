package com.data.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng
    private int id;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('USER','ADMIN') default 'USER'")
    private Role role;
    @Column(columnDefinition = "bit default 1")
    private boolean status;
}
