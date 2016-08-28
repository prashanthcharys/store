package com.mobilize.core.domain.value;
import java.io.Serializable;

public class UserPref1VO implements Serializable {
	private static final long serialVersionUID = -1L;
	private String uid;
	private String year;
	private String make;
	private String model;
	private String color;
	private String price;
	private String mileage;
	private String radius;
	
	public String getUid() {
		return uid;
	}
	public String getPrice() {
		return price;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getRadius() {
		return radius;
	}
	public void setRadius(String radius) {
		this.radius = radius;
	}
}
