package com.mobilize.core.domain.value;
import java.io.Serializable;
import java.util.Date;

public class SearchCriteriaVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = -1L;
	private String criteria;
	private Date timeStamp = new Date();	
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
