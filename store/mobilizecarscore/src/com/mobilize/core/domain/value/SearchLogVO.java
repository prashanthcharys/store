package com.mobilize.core.domain.value;
import java.io.Serializable;

public class SearchLogVO implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private String uid;
	private String make;
	private String model;
	private String color;
	private String year;
	
	public String getMake() {
		return make;
	}


	public String getModel() {
		return model;
	}


	public String getColor() {
		return color;
	}


	public String getYear() {
		return year;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public void setYear(String year) {
		this.year = year;
	}

	public String getUid() {
		return uid;
	}

}
