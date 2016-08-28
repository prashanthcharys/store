package com.mobilize.core.domain.value;
import java.io.Serializable;
import java.util.Date;

import com.mobilize.core.common.StringToDateUtil;

public class PaymentDetailsVO extends BaseVO implements Serializable {
	private static final long serialVersionUID = -1L;
	private String cardNumber;
	private String carId;
	private float amount;
	private Date transactionDate;
	private String tranDateString;
	private Date timeStamp = new Date();
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public String getTranDateString() {
		return tranDateString;
	}
	
	public void setTranDateString(String tranDateString) {
		this.tranDateString = tranDateString;
		transactionDate = StringToDateUtil.parseStringToDate(tranDateString, "mm/dd/yyy");
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
}
