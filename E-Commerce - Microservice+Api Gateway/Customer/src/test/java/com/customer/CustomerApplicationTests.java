package com.customer;

import com.customer.model.AuthenticationRequest;
import com.customer.model.CustomerLogin;
import com.customer.repository.CustomerLoginRepo;
import com.customer.repository.CustomerRepo;
import com.customer.service.CustomUserDetailService;
import com.customer.service.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerApplicationTests {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private CustomerLoginRepo customerLoginRepo;

	@Autowired
	private CustomerRepo  customerRepo;

	@Test
	public void registerCustomerTest(){
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("vishal12345","vishal@123");
		CustomerLogin customerLogin = new CustomerLogin();
		customerLogin.setPassword(authenticationRequest.getPassword());
		customerLogin.setUsername(authenticationRequest.getUsername());
		customerLoginRepo.save(customerLogin);
		assertNotNull(customerLoginRepo.findByUsername("vishal12345")); //Passed Successfully

	}


}
