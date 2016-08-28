package com.mobilize.core.domain.value;

public class LocationVO {
	private String userId;
	private String userType;
	private double latitude;	
	private double longitude;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[userId: "+userId);
		buffer.append("[userType: "+userType);
		buffer.append("[latitude: "+latitude);
		buffer.append("[longitude: "+longitude);
		buffer.append("]");
		return buffer.toString();
	}
}