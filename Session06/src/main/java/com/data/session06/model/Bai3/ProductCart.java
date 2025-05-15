package com.data.session06.model.Bai3;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCart {
    private int id;
    private int userId;
    private int productId;
    private int quantity;
    private String name;
    private double price;
}
