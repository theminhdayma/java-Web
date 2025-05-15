package com.data.session05.model.Bai9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private String publishDate;

}
