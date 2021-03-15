package com.bbolab.godingeta.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor(staticName = "of")
public class SignupRequestDto {

    @NotBlank
    @Length(min=6, max=20)
    @Pattern(regexp = "^[a-z0-9_-]{3,20}$")
    private String username;

    @NotBlank
    @Email
    private String email;

    // TODO : 패스워드 규칙 필요
    @NotBlank
    @Length(min=8, max=50)
    private String password;

}
