package com.data.session16.model;

import lombok.*;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Bus {
    private int id;
    private String licensePlate;
    private BusType busType;
    private int rowSeat;
    private int colSeat;
    private int totalSeat;
    private String image;
}
