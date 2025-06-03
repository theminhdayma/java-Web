package com.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int customerId;
    private String recipientName; 
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductCart> listProduct;
    private String phoneNumber;
    private String address;
    private double totalMoney;
    private Status status;
}
