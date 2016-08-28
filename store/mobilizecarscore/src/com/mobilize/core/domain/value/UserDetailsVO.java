package com.mobilize.core.domain.value;
import java.io.Serializable;
import java.util.Date;

public class UserDetailsVO extends UserVO implements Serializable {
	private static final long serialVersionUID = -1L;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private double longi;
	private double lati;
	private String homePhone;
	private String mobilePhone;
	private String emailId;
	private String resMessage;
	private Date timeStamp = new Date();

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getLongi() {
		return longi;
	}
	public void setLongi(double longi) {
		this.longi = longi;
	}
	public double getLati() {
		return lati;
	}
	public void setLati(double lati) {
		this.lati = lati;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
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
	
	public Address getAddress() {
		HomeAddressVO address = new HomeAddressVO();
		address.setStreet1(addressLine1);
		address.setStreet2(addressLine2);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		return address;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[firstName: "+this.firstName + "] ");
		sb.append("[lastName: "+this.lastName + "] ");
		sb.append("[addressLine1: "+this.addressLine1 + "] ");
		sb.append("[addressLine2: "+this.addressLine2 + "] ");
		sb.append("[city: "+this.city + "] ");
		sb.append("[state: "+this.state + "] ");
		sb.append("[zip: "+this.zip + "] ");
		sb.append("[country: "+this.country + "] ");
		sb.append("[homePhone: "+this.homePhone + "] ");
		sb.append("[mobilePhone: "+this.mobilePhone + "] ");
		sb.append("[emailId: "+this.emailId + "] ");
		sb.append("[resMessage: "+this.resMessage + "] ");
		return sb.toString();
	}
}