package com.data.session11.model.Bai1;

import lombok.*;

import javax.validation.constraints.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 30, message = "Tên phải từ 2 đến 30 ký tự")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    private String phone;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;

    private boolean status;
}
