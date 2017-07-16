package com.hibernate.study.log;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* @author 叶林生 
* @date：2017年7月15日 上午11:29:25
* @version 1.0
* 
*/
@Entity(name="log")
@Table(name="HTeacher")
public class Teacher {

	private int id;
	private String name;
	private String title;
	
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
}
