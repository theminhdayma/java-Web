package com.data.session15.model.Bai6_7_8_9;

import lombok.*;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class OrderDetail {
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private Double currentPrice;
}
