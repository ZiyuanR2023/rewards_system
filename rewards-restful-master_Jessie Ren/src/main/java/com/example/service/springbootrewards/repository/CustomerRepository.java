package com.example.service.springbootrewards.rewards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.service.springbootrewards.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
  
  @Query("select customer from Customer c left join Transaction t on c.transaction_id = t.transaction_id where c.customer_id = customerId and t.transaction_date between startDate and endDate")
  Customer getThreeMonthsTransactionsById(@Param("customerId") Integer id, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
