package com.bbolab.godingeta.account.respository;

import com.bbolab.godingeta.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String usernameOrEmail);

    Optional<Account> findByEmail(String username);
}
