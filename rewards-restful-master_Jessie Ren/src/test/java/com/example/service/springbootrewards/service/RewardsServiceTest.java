package com.example.service.springbootrewards.service;

import org.mockito.InjectMocks;
import org.mockito.Mocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import org.jupiter.api.Assertions;
import org.jupiter.api.BeforeEach;
import org.jupiter.api.Test;
import org.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class RewardsServiceTest{
    @MockitoExtension
    private CustomerRepository customerRepository;

    @MockitoExtension
    private DataUtil dataUtil;

    @InjectMocks
    private RewardsService rewardsService;

    @BeforeEach
    public void setup(){RestAssuredMockMvc.standaloneSetup(controller);}

    @Test
    void findCustomerRewardsByIdTest() {
        Customer customer = new Customer();
        customer.setId(1l);
        customer.setName("testName");
        Transaction transaction = new Transaction();
        transaction.setId(10l);
        transaction.setCustomer(customer);
        transaction.setTotal(120);
        Set<Transaction> transactions = new HashSet<>();
        transactions.add(transaction);
        customer.setTransactions(transactions);
        Reward reward = new Reward();
        reward.setPoints(90);
        when(customerRepository.findById(1l)).thenReturn(customer);
        when(dataUtil.getRewardPoints(transactions)).thenReturn(reward);
        Reward rewardReal = RewardsService.findCustomerRewardsById(1l);
        assertEquals(90, rewardReal.getPoints());
	}
}
