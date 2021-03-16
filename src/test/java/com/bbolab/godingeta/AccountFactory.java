package com.bbolab.godingeta;

import com.bbolab.godingeta.account.domain.Account;
import com.bbolab.godingeta.account.dto.SignupRequestDto;
import com.bbolab.godingeta.account.respository.AccountRepository;
import com.bbolab.godingeta.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountFactory {

    @Autowired AccountRepository accountRepository;

    @Autowired AccountService accountService;

    public Account createAccount(String name) {
        SignupRequestDto signUpRequestDto = SignupRequestDto.of(name, name + "@test.com", "testpass");
        return accountService.signup(signUpRequestDto);
    }
}