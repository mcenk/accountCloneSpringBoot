package com.mcenk.account.dto;

import com.mcenk.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convertTransactionDto(Transaction from){

        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDateTime());
    }
}
