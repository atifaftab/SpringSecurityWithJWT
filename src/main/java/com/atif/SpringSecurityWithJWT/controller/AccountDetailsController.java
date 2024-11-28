package com.atif.SpringSecurityWithJWT.controller;


import com.atif.SpringSecurityWithJWT.model.AccountDetails;
import com.atif.SpringSecurityWithJWT.service.AccountDetailsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountDetailsController {
    private final AccountDetailsService accountDetailsService;

    public AccountDetailsController(AccountDetailsService accountDetailsService) {
        this.accountDetailsService = accountDetailsService;
    }

    @GetMapping("/details")
    public AccountDetails getAccountDetails(@AuthenticationPrincipal UserDetails userDetails) {
        return accountDetailsService.getAccountDetails(userDetails);
    }

    @PutMapping("/details")
    public AccountDetails updateAccountDetails(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody AccountDetails newDetails) {
        return accountDetailsService.updateAccountDetails(userDetails, newDetails);
    }
}
