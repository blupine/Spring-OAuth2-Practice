package com.bbolab.godingeta.account.service;

import com.bbolab.godingeta.account.domain.Account;
import com.bbolab.godingeta.account.dto.LoginRequestDto;
import com.bbolab.godingeta.account.dto.SignupRequestDto;
import com.bbolab.godingeta.account.respository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    @Override
    public void login(LoginRequestDto loginRequestDto) {
        // TODO : JWT 기반 login 서비스 작성 필요
    }

    @Override
    public Account signup(SignupRequestDto signupRequestDto) {
        // TODO : Signup 후에 Login 처리 & JWT 토큰 반환
        signupRequestDto.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        Account account = modelMapper.map(signupRequestDto, Account.class);
        return accountRepository.save(account);
    }
}
