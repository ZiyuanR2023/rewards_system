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
			points += (total.intValue() - 100) * 2;  //2 points for every dollar spent over $100
        }
        return points;
    }

    public static Long getRewardPoints(Set<Transaction> transactions) {
		if (transactions == null || transactions.isEmpty()) return 0l;
		return transactions.stream().map(x -> DataUtil.getPoints(x.total).intValue()).reduce(0, (a,b) -> a + b).longValue();
    }
	
    public static Date getDate(String date){
	    Date dateFormatted = new SimpleDateFormat("yyyy-MM-dd").parse(date);
	    return dateFormatted;
	    //LocalDate currentDate = LocalDate.parse(date);
	    //LocalTime currentTime = LocalTime.of(0,0,0,0);
	    //return LocalDateTime.of(currentDate, currentTime);
    }
	
    public static String getEndDate(String startDate){
	    //startDate = "2018-01-01"
	    String[] dates = start
	    //startDate = startDate.split("-");
            int month = Integer.parseInt(dates[1]); //"01"
	    int endMonth = Math.max(12, month+2);
	    String endDate = dates[0] + "-" + endMonth + "-" + dates[2];
	    return endDate;
    }

}
