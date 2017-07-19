package com.hibernate.study.core.threeStatus.basicMethod;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
* @author 叶林生 
* @date：2017年7月15日 上午11:29:25
* @version 1.0
* 实体bean中所有的非static非transient的属性都可以被持久化, 
* 除非你将其注解为@Transient.所有没有定义注解的属性等价于在其上面添加了@Basic注解. 
* 通过 @Basic注解可以声明属性的获取策略(fetch strategy)
*/
@Entity
public class Teacher {

	private int id;
	private String name;
	private String title;
	
	public Teacher(){
		System.out.println("i am a teacher");
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTitle() {
		return title;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
