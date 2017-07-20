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
public class BiHusband {
	
	private int id;
	private String name;
	private BiWife wife;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	//OneToOne不能给这个属性添加相关的属性，例如名字，长度等
	@OneToOne
	@PrimaryKeyJoinColumn
	public BiWife getWife() {
		return wife;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWife(BiWife wife) {
		this.wife = wife;
	}

}
