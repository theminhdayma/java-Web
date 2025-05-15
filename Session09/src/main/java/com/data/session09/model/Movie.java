package com.data.session09.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Movie {
    private Long id;
    private String title;
    private String director;
    private String genre;
    private String description;
    private Integer duration;
    private String language;
}

