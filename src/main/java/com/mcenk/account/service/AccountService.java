package com.mcenk.account.service;

import com.mcenk.account.dto.AccountDto;
import com.mcenk.account.dto.CreateAccountRequest;
import com.mcenk.account.model.Account;
import com.mcenk.account.model.Customer;
import com.mcenk.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

  private final AccountRepository accountRepository;
  private final CustomerService customerService;


  public AccountService(AccountRepository accountRepository, CustomerService customerService) {
    this.accountRepository = accountRepository;
    this.customerService = customerService;
  }

  public AccountDto createAccount (CreateAccountRequest createAccountRequest){
    Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

    Account account= new Account(customer,createAccountRequest.getInitialCredit(), LocalDateTime.now());


    // Big decimal degerleri dogrudan buyuk kucuk seklende yazamiyoruz
    // onunn yerine compare to kullaniyoruz
    // 1 buyuk  0 esit -1 kucuk olarak donuyor

    if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) >0){




    }

      return AccountDto ;
    }


}
