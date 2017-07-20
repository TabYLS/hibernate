package com.hibernate.study.orm.component.xml;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class StuIdCard {
	private String num;
	private Date date;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
