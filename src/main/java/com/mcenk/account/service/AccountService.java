package com.mcenk.account.service;

import com.mcenk.account.dto.AccountDto;
import com.mcenk.account.dto.AccountDtoConverter;
import com.mcenk.account.dto.CreateAccountRequest;
import com.mcenk.account.model.Account;
import com.mcenk.account.model.Customer;
import com.mcenk.account.model.Transaction;
import com.mcenk.account.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

  private final AccountRepository accountRepository;
  private final CustomerService customerService;
  private  final TransactionService transactionService;
  private final AccountDtoConverter converter;
  Logger logger= LoggerFactory.getLogger(AccountService.class);


// Conveter service olmadigi halde inject edilebildi
  // Conponent notasyonu ile imzaladigimiz icin yapabildik

  public AccountService(AccountRepository accountRepository,
                        CustomerService customerService,
                        TransactionService transactionService,
                        AccountDtoConverter converter) {
    this.accountRepository = accountRepository;
    this.customerService = customerService;
    this.transactionService= transactionService;
    this.converter=converter;
  }

  public AccountDto createAccount (CreateAccountRequest createAccountRequest){
    Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
    logger.warn(customer.toString());

    Account account= new Account(customer,createAccountRequest.getInitialCredit(), LocalDateTime.now());
    logger.warn(account.toString());

    // Big decimal degerleri dogrudan buyuk kucuk seklende yazamiyoruz
    // onunn yerine compare to kullaniyoruz
    // 1 buyuk  0 esit -1 kucuk olarak donuyor

    if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) >0){

      Transaction transaction=transactionService.initiateMoney(account, createAccountRequest.getInitialCredit());

      account.getTransaction().add(transaction);


    }
      return converter.convert(accountRepository.save(account));

    }


}
