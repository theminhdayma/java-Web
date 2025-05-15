package com.data.session07.model.Bai9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor@Getter@NoArgsConstructor@Setter
public class Product {
    private int id;
    private String name;
    private double price;
    private int categoryId;
}
