package com.example.service.springbootrewards.rewards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.service.springbootrewards.model.Customer;

@Service
public interface RewardsService {
	
	public List<Customer> getCustomerAll() {}
	

}
