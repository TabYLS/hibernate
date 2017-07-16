package com.hibernate.study.model.annotation.basic;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
* @author 叶林生 
* @date：2017年7月15日 上午11:29:25
* @version 1.0
* 实体bean中所有的非static非transient的属性都可以被持久化, 
* 除非你将其注解为@Transient.所有没有定义注解的属性等价于在其上面添加了@Basic注解. 
* 通过 @Basic注解可以声明属性的获取策略(fetch strategy)
*/
@Entity(name="basic")
@Table(name="basic_teacher")
public class Teacher {

	private int id;
	private String name;
	private String title;
	private double myMoney;
	private Date birthday;
	private Gender gender;
	
	@Id
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Transient
	public double getMyMoney() {
		return myMoney;
	}
	public void setMyMoney(double myMoney) {
		this.myMoney = myMoney;
	}
	//注解日期TemporalType.DATE（只是日期不包含时间），TemporalType.TIME(只是时间没有日期)，TemporalType.TIMESTAMP（时间和日期）
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	//注解枚举类型EnumType.ORDINAL(枚举的下标),EnumType.STRING枚举的值
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
