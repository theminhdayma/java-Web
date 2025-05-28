package com.data.session14.model.Bai9;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private String description;
    private double amount;
    private String type;
}
