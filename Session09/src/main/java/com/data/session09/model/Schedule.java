package com.data.session09.model;

import java.util.Date;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String movieTitle;
    private Date showTime;
    private Long screenRoomId;
    private Integer availableSeats;


}

