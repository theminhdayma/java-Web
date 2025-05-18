package com.data.session10.model.Bai9;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private String description;
    private MultipartFile file;
}
