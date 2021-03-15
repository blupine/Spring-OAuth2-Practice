package com.bbolab.godingeta.account.service;

import com.bbolab.godingeta.account.domain.Account;
import com.bbolab.godingeta.account.dto.LoginRequestDto;
import com.bbolab.godingeta.account.dto.SignupRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    void login(LoginRequestDto loginRequestDto);

    Account signup(SignupRequestDto signupRequestDto);

}
