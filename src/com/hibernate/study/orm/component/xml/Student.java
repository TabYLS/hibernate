package com.hibernate.study.orm.component.xml;

public class Student {
	
	private int id;
	private String name;
	private int age;
	private String sex;
	private boolean good;
	private StuIdCard idCard;
	public boolean isGood() {
		return good;
	}
	public void setGood(boolean good) {
		this.good = good;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public StuIdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(StuIdCard idCard) {
		this.idCard = idCard;
	}
	
}
