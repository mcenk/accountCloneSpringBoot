package com.mcenk.account.dto;

import com.mcenk.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final CustomerDtoConverter customerDtoConverter;
    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(CustomerDtoConverter customerDtoConverter, TransactionDtoConverter transactionDtoConverter) {
        this.customerDtoConverter = customerDtoConverter;
        this.transactionDtoConverter= transactionDtoConverter;
    }

    public AccountDto convert(Account from ){
        return new AccountDto(from.getId(),
                from.getBalance(),
                from.getCreationDate(),
                customerDtoConverter.convertAccountCustomerDto(from.getCustomer()),
                from.getTransaction().stream()
                        .map(transactionDtoConverter::convertTransactionDto)
                        .collect(Collectors.toSet())
                );
    }
}
