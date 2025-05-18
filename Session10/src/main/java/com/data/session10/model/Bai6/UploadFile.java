package com.data.session10.model.Bai6;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UploadFile {
    private MultipartFile file;
    private String description;
    private String fileUrl;
}
