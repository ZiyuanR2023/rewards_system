package com.example.service.springbootrewards.vo;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
public class Reward {

	private  Long points;

	public Long getPoints() {
		return id;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
}
