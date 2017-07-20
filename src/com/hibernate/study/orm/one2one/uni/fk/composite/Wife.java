package com.hibernate.study.orm.one2one.uni.fk.composite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
* @author 叶林生 
* @date：2017年7月19日 下午8:13:04
* @version 1.0
* 
*/
@Entity
@IdClass(WifePK.class)
public class Wife {
	
	private int id;
	private String name;
	private int age;
	
	public int getAge() {
		return age;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	@Id
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
