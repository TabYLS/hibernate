package com.hibernate.study.orm.one2one.bi.pk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
* @author 叶林生 
* @date：2017年7月19日 下午8:13:04
* @version 1.0
* 
*/
@Entity
public class BiWife {
	
	private int id;
	private String name;
	private BiHusband husband;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	public BiHusband getHusband() {
		return husband;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setHusband(BiHusband husband) {
		this.husband = husband;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}
