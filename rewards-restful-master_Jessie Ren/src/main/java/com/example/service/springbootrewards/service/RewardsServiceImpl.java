package com.example.service.springbootrewards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.service.springbootrewards.model.Customer;

@Service
public class RewardsServiceImpl implements RewardService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RewardsServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Reward findCustomerRewardsById(Integer customerId) {
		LOGGER.info("Enter RewardsService::find rewards for all customers");
		Customer customerStatus = customerRepository.findById(customerId).orElse(null);
		Set<Transaction> transactions = customerStatus.getTransactions();
		Reward reward = new Reward();
		reward.setPoints(DataUtil.getRewardPoints(transactions));
		return reward;
	}

}
