package com.bbolab.godingeta.account.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class LoginRequestDto {
    private String username;
    private String password;
}
