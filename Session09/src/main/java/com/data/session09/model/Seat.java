package com.data.session09.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Seat {
    private Long id;
    private String seatNumber;
    private boolean isBooked;

}
