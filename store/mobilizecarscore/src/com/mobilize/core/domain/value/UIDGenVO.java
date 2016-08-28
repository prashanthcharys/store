package com.mobilize.core.domain.value;

import java.io.Serializable;
import java.util.Date;

public class UIDGenVO implements Serializable {
	private static final long serialVersionUID = -6274802809112978335L;
	
	private int objId;
	private String objectType;
	private int count;
	private Date timeStamp = new Date();
	
	public int getObjId() {
		return objId;
	}
	public void setObjId(int objId) {
		this.objId = objId;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public void incrementCount() {
		this.count++;
	}
}