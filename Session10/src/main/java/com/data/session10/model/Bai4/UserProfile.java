package com.data.session10.model.Bai4;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserProfile {
    private String username;
    private MultipartFile avatar;
}
