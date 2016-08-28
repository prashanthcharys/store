package com.mobilize.core.domain.value;

import java.io.Serializable;
import java.util.Date;

public class UserVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String password;
	private String status;
	private String errorMessage;
	private Date timeStamp = new Date();
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}