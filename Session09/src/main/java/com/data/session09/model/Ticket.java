package com.data.session09.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Ticket {
    private Long id;
    private Long customerId;
    private Long scheduleId;
    private Long seatId;
    private Double price;

}


