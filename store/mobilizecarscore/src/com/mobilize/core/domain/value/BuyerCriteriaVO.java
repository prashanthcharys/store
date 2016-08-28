package com.mobilize.core.domain.value;

import java.io.Serializable;
import java.util.Date;

public class BuyerCriteriaVO extends BuyerCriteriaSummaryVO implements Serializable {
	private static final long serialVersionUID = 317395880830633671L;
	private String yearFrom;
	private String yearTo;
	private double priceFrom;
	private double priceTo;
	private int mileage;
	private int radius;
	private int yearPref;
	private int makePref;
	private int modelPref;
	private int colorPref;
	private int pricePref;
	private int mileagePref;
	private int radiusPref;
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
	public double getPriceFrom() {
		return priceFrom;
	}
	public void setPriceFrom(double priceFrom) {
		this.priceFrom = priceFrom;
	}
	public double getPriceTo() {
		return priceTo;
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
	public int getYearPref() {
		return yearPref;
	}
	public void setYearPref(int yearPref) {
		this.yearPref = yearPref;
	}
	public int getMakePref() {
		return makePref;
	}
	public void setMakePref(int makePref) {
		this.makePref = makePref;
	}
	public int getModelPref() {
		return modelPref;
	}
	public void setModelPref(int modelPref) {
		this.modelPref = modelPref;
	}
	public int getColorPref() {
		return colorPref;
	}
	public void setColorPref(int colorPref) {
		this.colorPref = colorPref;
	}
	public int getPricePref() {
		return pricePref;
	}
	public void setPricePref(int pricePref) {
		this.pricePref = pricePref;
	}
	public int getMileagePref() {
		return mileagePref;
	}
	public void setMileagePref(int mileagePref) {
		this.mileagePref = mileagePref;
	}
	public int getRadiusPref() {
		return radiusPref;
	}
	public void setRadiusPref(int radiusPref) {
		this.radiusPref = radiusPref;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
