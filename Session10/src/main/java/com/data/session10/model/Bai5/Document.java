package com.data.session10.model.Bai5;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Document {
    private int id;
    private String title;
    private String description;
    private MultipartFile fileName;
}
