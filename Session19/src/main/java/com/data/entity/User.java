package com.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Họ tên không được để trống!")
    private String firstName;

    @NotBlank(message = "Tên không được đê trống!")
    private String lastName;
    private String phone;
    private String address;
    private transient MultipartFile file;
    private String fileImage;
}
