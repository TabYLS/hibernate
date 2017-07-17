package com.hibernate.study.id.union.annotation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
* @author 叶林生 
* @date：2017年7月15日 上午11:29:25
* @version 1.0
* 实体bean中所有的非static非transient的属性都可以被持久化, 
* 除非你将其注解为@Transient.所有没有定义注解的属性等价于在其上面添加了@Basic注解. 
* 通过 @Basic注解可以声明属性的获取策略(fetch strategy)
*/
@Entity
@IdClass(TeacherPK.class)
public class Teacher{

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
	@Id
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
