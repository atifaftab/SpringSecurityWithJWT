package com.atif.SpringSecurityWithJWT.repository;

import com.atif.SpringSecurityWithJWT.model.AccountDetails;
import com.atif.SpringSecurityWithJWT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
    Optional<AccountDetails> findByUser(User user);
}
