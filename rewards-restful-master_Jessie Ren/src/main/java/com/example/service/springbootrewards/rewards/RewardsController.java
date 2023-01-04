package com.example.service.springbootrewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.service.springbootrewards.model.Customer;
import com.example.service.springbootrewards.model.MyTransaction;

@RequestMapping(value = "/api/rewards/")
@RestController
public class RewardsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RewardsController.class);
	//@Autowired
	//private RewardsServiceMock rewardsService;
	
	@Autowired
	private RewardsService rewardsService;
	
	
	
	@RequestMapping(value="findRewardsAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Customer>> findRewardsAll() {
		LOGGER.info("find rewards for all customers.");
		List<Customer> customerStatus = rewardsService.getCustomerAll();
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	// @GetMapping("/customers/{id}")
	// public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
	// 	Customer customer = rewardsService.getCustomerById(id);
	// 	if (customer == null) return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	// 	return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	// }
	
	
}
