package com.mobilize.core.domain.value;

import java.io.Serializable;
import java.util.Date;

public class UserCriteriaVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String yearFrom;
	private String yearTo;
	private String make;
	private String model;
	private String color;
	private double priceFrom;
	private double priceTo;
	private int mileage;
	private int radius;
	private Date timeStamp = new Date();

	public String getYearFrom() {
		return yearFrom;
	}
	public void setYearFrom(String yearFrom) {
		this.yearFrom = yearFrom;
	}
	public String getYearTo() {
		return yearTo;
	}
	public void setYearTo(String yearTo) {
		this.yearTo = yearTo;
	}
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
	public double getPriceFrom() {
		return priceFrom;
	}
	public double getPriceTo() {
		return priceTo;
	}
	public void setPriceFrom(double priceFrom) {
		this.priceFrom = priceFrom;
	}
	public void setPriceTo(double priceTo) {
		this.priceTo = priceTo;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	//-- TODO to be implemented
	public String toString() {
		return null;
	}
	
	//-- TODO to be implemented
	public boolean isEqual() {
		return false;
	}

}
