package com.data.session12.model;

import java.time.LocalDateTime;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String image;
    private Status status;
    private LocalDateTime createdAt;
}
