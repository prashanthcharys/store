package com.mobilize.core.domain.value;

import com.mobilize.core.exception.ReferenceDataException;

public abstract class Address {
	
	private String street1 = null;
	private String street2 = null;
	private String city = null;
	private String state = null;
	private String zip = null;
	private String country = null;
	private String county = null;
	private String type = null;			//This would define if this is Home/Buss/Alter
	
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
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
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) throws ReferenceDataException {
		this.type = type;
	}

}
