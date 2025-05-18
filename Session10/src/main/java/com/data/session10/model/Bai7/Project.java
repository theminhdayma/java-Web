package com.data.session10.model.Bai7;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {
    private int id;
    private String name;
    private String description;
    private List<MultipartFile> documents;
}
