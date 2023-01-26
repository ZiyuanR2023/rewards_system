package com.example.service.springbootrewards.controller;

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
class RewardsControllerTest{
    @Mock
    private RewardsService rewardsService;

    @InjectMocks
    private RewardsController controller;

    private static final String BASE_URL = "/api/rewards/";

    @BeforeEach
    public void setup(){RestAssuredMockMvc.standaloneSetup(controller);}

    @Test
    void findCustomerRewardsById(){
        Reward reward = new Reward();
        reward.setPoints(10);
        when(rewardsService.findCustomerRewardsById(any())).thenReturn(reward);
        Reward reward = given()
                        .accept(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("customerId", 1)
                        .when()
                        .get(BASE_URL + "findCustomerRewardsAll")
                        .then()
                        .statusCode(200)
                        .assertThat()
                        .extract.as(Reward.class);
        assertEquals(10, reward.getPoints());
    }
}
