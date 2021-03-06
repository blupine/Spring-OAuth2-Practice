package com.bbolab.godingeta.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
public class LoginRequestDto {
    private String username;
    private String password;
}
