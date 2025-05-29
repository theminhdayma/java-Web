package com.data.session15.model.Bai6_7_8_9;

import lombok.*;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Orders {
    private int id;
    private int userId;
    private String recipientName;
    private String address;
    private String phoneNumber;
}
