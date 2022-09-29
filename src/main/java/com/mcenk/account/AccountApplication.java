package com.mcenk.account;

import com.mcenk.account.model.Customer;
import com.mcenk.account.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;
	Logger logger= LoggerFactory.getLogger(AccountApplication.class);

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		Customer customer= customerRepository.save(new Customer("","Serra", "Cenk", new HashSet<>()));
			logger.warn(customer.toString());
		System.out.println(customer);

	}
}
