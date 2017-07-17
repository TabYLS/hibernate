package com.hibernate.study.id.annotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	
	@Id
	//identity由底层数据库生成标识符。identity是由数据库自己生成的，但这个主键必须设置为自增长，
	//使用identity的前提条件是底层数据库支持自动增长字段类型，如DB2、SQL Server、MySQL、Sybase和HypersonicSQL等，
	//Oracle这类没有自增字段的则不支持。
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
