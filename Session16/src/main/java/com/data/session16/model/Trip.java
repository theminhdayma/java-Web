package com.data.session16.model;

import lombok.*;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Trip {
    private int id;
    private String title;
    private String description;
    private String startPoint;
    private String endPoint;
    private Double price;
    private Status status;
}
