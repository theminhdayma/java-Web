package com.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;


@Entity
@Table(name = "movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên phim không được để trống")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Đạo diễn không được để trống")
    @Column(nullable = false)
    private String director;

    @Min(value = 1900, message = "Năm phát hành phải từ 1900 trở lên")
    @Max(value = 2025, message = "Năm phát hành không được vượt quá năm hiện tại")
    @Column(name = "release_year")
    private Integer releaseYear;

    private String genre;

    @Positive(message = "Thời lượng phim phải lớn hơn 0")
    private Integer duration;

    private String language;

    @Column(name = "poster")
    private String poster;

    @Column(name = "status")
    private boolean status = true;
}