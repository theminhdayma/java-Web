package com.data.session05.model.Bai8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Task {
    private int id;
    private String description;
    private String dueDate;
    private boolean completed;


}
