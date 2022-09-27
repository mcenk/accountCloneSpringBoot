package com.mcenk.account.dto;

import com.mcenk.account.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public AccountCustomerDto convertAccountCustomerDto (Customer from){

        if ( from == null){
            return new AccountCustomerDto("", "", "");

        }
        return new AccountCustomerDto(from.getId(),
                from.getName(),
                from.getSurname()
                );
    }
}
