package com.bbolab.godingeta.account.service;

import com.bbolab.godingeta.account.authentication.UserAccount;
import com.bbolab.godingeta.account.domain.Account;
import com.bbolab.godingeta.account.dto.AccountDto;
import com.bbolab.godingeta.account.dto.LoginRequestDto;
import com.bbolab.godingeta.account.dto.LoginResultDto;
import com.bbolab.godingeta.account.dto.SignupRequestDto;
import com.bbolab.godingeta.account.respository.AccountRepository;
import com.bbolab.godingeta.security.jwt.tokenProvider.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public Optional<LoginResultDto> login(LoginRequestDto loginRequestDto) {
        // TODO : JWT 기반 login 서비스 작성 필요
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        UserAccount userAccount = (UserAccount)authenticate.getPrincipal();
        Account account = userAccount.getAccount();
        LoginResultDto dto = modelMapper.map(account, LoginResultDto.class);
        dto.setJwtToken(jwtTokenProvider.createToken(account.getUsername()));
        return Optional.ofNullable(dto);
    }

    @Override
    public Account signup(SignupRequestDto signupRequestDto) {
        signupRequestDto.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        Account account = modelMapper.map(signupRequestDto, Account.class);
        return accountRepository.save(account);
    }
}
