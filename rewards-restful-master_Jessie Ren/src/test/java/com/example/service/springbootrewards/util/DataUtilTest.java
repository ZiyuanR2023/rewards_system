package com.example.service.springbootrewards.util;

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
public class DataUtilTest{

    @InjectMocks
    private DataUtil dataUtil;

    @BeforeEach
    public void setup(){RestAssuredMockMvc.standaloneSetup(controller);}

    @Test
    public void getPointsTest(){
		Double total = 120.0;
		assertEquals(90, dataUtil.getPoints(total));
    }

	@Test
    public void getRewardPointsTest() {
		Transaction transaction = new Transaction();
        transaction.setId(10l);
        transaction.setCustomer(customer);
        transaction.setTotal(120);
        Set<Transaction> transactions = new HashSet<>();
		transactions.add(transaction);
		assertEquals(90, dataUtil.getRewardPoints(total));
	}

}
