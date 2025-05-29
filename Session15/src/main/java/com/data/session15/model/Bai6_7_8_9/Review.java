package com.data.session15.model.Bai6_7_8_9;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Review {
    private int id;
    private int productId;
    private int userId;
    private int rating;
    private String comment;
}
