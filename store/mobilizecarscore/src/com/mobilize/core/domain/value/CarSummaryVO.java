package com.mobilize.core.domain.value;

import java.io.Serializable;

public class CarSummaryVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = -2862007074499698036L;
	private String make;
	private String model;
	private double latitude;
	private double longitude;
	
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
