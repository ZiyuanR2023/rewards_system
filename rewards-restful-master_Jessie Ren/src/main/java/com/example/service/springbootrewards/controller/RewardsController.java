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
	
	@Autowired
	private RewardsService rewardsService;
	

	
	@RequestMapping(value = "findCustomerRewardsAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "findCustomerRewardsAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Reward> findCustomerRewardsById(@RequestParam Integer customerId, @RequestParam String startDate) {
		LOGGER.info("Enter RewardsController::find rewards for all customers");
		Reward reward = rewardsService.findCustomerRewardsById(customerId, startDate);
		return new ResponseEntity<Reward>(reward, HttpStatus.OK);
	}
	
	
	
}
