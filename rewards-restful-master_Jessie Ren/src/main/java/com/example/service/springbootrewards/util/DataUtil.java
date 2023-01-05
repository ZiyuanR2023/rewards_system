package com.example.service.springbootrewards.util;

import com.antra.report.client.entity.ReportRequestEntity;

import java.util.StringJoiner;

import org.springframework.data.jpa.repository.JpaRepository;

public class DataUtil{
    public static Long getPoints(Double total){
        Long points = 0l;
        if (total > 50 && total <= 100) {
			points += (total.intValue() - 50) * 1;
			
		} 
		
		if (total > 100) {
			points += 50;  //1 point for every dollar spent over $50
			points += (otal.intValue() - 100) * 2;  //2 points for every dollar spent over $100
        }
        return points;
    }

    public static Long getRewardPoints(Set<Transaction> transactions) {
		if (transactions == null || transactions.isEmpty()) return 0l;
		return transactions.stream().map(x -> DataUtil.getPoints(x.total).intValue()).reduce(0, (a,b) -> a + b).longValue();
	}

}
