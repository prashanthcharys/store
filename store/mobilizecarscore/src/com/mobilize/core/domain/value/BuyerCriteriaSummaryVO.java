package com.mobilize.core.domain.value;

import java.io.Serializable;

public class BuyerCriteriaSummaryVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = 1483965175839669273L;
	
	private String make;
	private String model;
	private String color;

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
