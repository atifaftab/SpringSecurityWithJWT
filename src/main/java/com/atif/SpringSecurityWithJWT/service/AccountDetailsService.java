package com.atif.SpringSecurityWithJWT.service;

import com.atif.SpringSecurityWithJWT.model.AccountDetails;
import com.atif.SpringSecurityWithJWT.model.User;
import com.atif.SpringSecurityWithJWT.repository.AccountDetailsRepository;
import com.atif.SpringSecurityWithJWT.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountDetailsService {
    private final AccountDetailsRepository accountDetailsRepository;
    private final UserRepository userRepository;

    public AccountDetails getAccountDetails(UserDetails userDetails) {
        User user = getUserFromDetails(userDetails);
        return accountDetailsRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Account details not found for user"));
    }

    public AccountDetails updateAccountDetails(UserDetails userDetails, AccountDetails newDetails) {
        User user = getUserFromDetails(userDetails);

        AccountDetails accountDetails = accountDetailsRepository.findByUser(user)
                .orElse(new AccountDetails());
        accountDetails.setUser(user);
        accountDetails.setFullName(newDetails.getFullName());
        accountDetails.setEmail(newDetails.getEmail());
        accountDetails.setPhoneNumber(newDetails.getPhoneNumber());

        return accountDetailsRepository.save(accountDetails);
    }

    private User getUserFromDetails(UserDetails userDetails) {
        return userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
