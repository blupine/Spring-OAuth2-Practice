package com.bbolab.godingeta.account.service;

import com.bbolab.godingeta.account.domain.Account;
import com.bbolab.godingeta.account.dto.AccountDto;
import com.bbolab.godingeta.account.dto.LoginRequestDto;
import com.bbolab.godingeta.account.dto.LoginResultDto;
import com.bbolab.godingeta.account.dto.SignupRequestDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AccountService {

    Optional<LoginResultDto> login(LoginRequestDto loginRequestDto);

    Account signup(SignupRequestDto signupRequestDto);

}
