package com.data.session14.model.Bai6;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @NotEmpty(message = "{user.username.empty}")
    private String username;

    @Size(min = 6, message = "{user.password.length}")
    private String password;

    private String confirmPassword;

    @NotEmpty(message = "{user.email.invalid}")
    @Email(message = "{user.email.invalid}")
    private String email;

}
