package com.data.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.data.entity.Role;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {
    private int id;
    @NotBlank(message = "Username không được để trống")
    private String username;
    @NotBlank(message = "Password không được để trống")
    @Size(min = 6, message = "Password phải có ít nhất 6 ký tự")
    private String password;
    @Email(message = "Email không hợp lệ")
    private String email;
    private String phoneNumber;
    private Role role;
    private boolean status;
}
