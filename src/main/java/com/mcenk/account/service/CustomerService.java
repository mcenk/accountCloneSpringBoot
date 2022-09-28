package com.mcenk.account.service;

import com.mcenk.account.exception.CustomerNotFoundException;
import com.mcenk.account.model.Customer;
import com.mcenk.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    // benim amacim sifirdan customer uretmek degil
    // customer service servis paketi altinda diger servisler ile iletisim icerinde olacak
    // o nedenle protected kullandik

    protected Customer findCustomerById (String id){
        return customerRepository
                .findById(id)
                .orElseThrow( ()-> new CustomerNotFoundException("Customer could not find by id : " + id));
    }


}
