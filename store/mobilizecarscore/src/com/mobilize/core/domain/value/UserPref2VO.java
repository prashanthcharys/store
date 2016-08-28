package com.mobilize.core.domain.value;
import java.io.Serializable;

public class UserPref2VO implements Serializable {
	private static final long serialVersionUID = -1L;
	private String uid;
	private String radius;
	private String notifygn;
	private String notifyyl;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	public String getUid() {
		return uid;
	}
	public String getRadius() {
		return radius;
	}
	public String getNotifygn() {
		return notifygn;
	}
	public String getNotifyyl() {
		return notifyyl;
	}
	public String getQuestion1() {
		return question1;
	}
	public String getAnswer1() {
		return answer1;
	}
	public String getQuestion2() {
		return question2;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setRadius(String radius) {
		this.radius = radius;
	}
	public void setNotifygn(String notifygn) {
		this.notifygn = notifygn;
	}
	public void setNotifyyl(String notifyyl) {
		this.notifyyl = notifyyl;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
}
