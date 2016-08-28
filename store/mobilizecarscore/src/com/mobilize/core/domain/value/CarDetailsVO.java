package com.mobilize.core.domain.value;
import java.io.Serializable;
import java.util.Date;

public class CarDetailsVO extends CarSummaryVO implements Serializable {
	private static final long serialVersionUID = -1L;
	private String year;
	private String color;
	private String zipCode;
	private int mileage;	
	private double price;
	private String comments;
	private String mobilePhone;
	private String emailId;
	private String sellerName;
	
	//for screen start
	private String resMessage;
	//for screen end
	private Date timeStamp = new Date();

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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public double getPrice() {
		return price;
	}
	public String getComments() {
		return comments;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getResMessage() {
		return resMessage;
	}
	public void setResMessage(String resMessage) {
		this.resMessage = resMessage;
	}
}
