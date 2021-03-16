package com.bbolab.godingeta.account.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class LoginResultDto {
    private String username;
    private String email;
    private String jwtToken;
}
