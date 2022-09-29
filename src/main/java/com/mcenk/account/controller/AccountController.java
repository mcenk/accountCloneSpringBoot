package com.mcenk.account.controller;

import com.mcenk.account.dto.AccountDto;
import com.mcenk.account.dto.CreateAccountRequest;
import com.mcenk.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {


    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping()
    public ResponseEntity<AccountDto> createAccount (@RequestBody CreateAccountRequest request){

       return ResponseEntity.ok(accountService.createAccount(request)); //

        // http status ve anlamlarina tekrar bak


       // put ve patch arasindaki fark nedir?


    }
}
