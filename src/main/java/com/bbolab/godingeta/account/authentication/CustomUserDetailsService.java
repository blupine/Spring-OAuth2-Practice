package com.bbolab.godingeta.account.authentication;

import com.bbolab.godingeta.account.domain.Account;
import com.bbolab.godingeta.account.respository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optional = accountRepository.findByUsername(username);

        if (optional.isEmpty()){
            optional = accountRepository.findByEmail(username);
        }
        if(optional.isEmpty()){
            return null;
        }

        return new UserAccount(optional.get());
    }
}
