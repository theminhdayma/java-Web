package com.data.session15.model.Bai3;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @NotBlank(message = "Tên không được để trống")
    private String name;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @Size(min = 6, message = "Mật khẩu phải từ 6 ký tự")
    private String password;
}
