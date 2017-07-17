package com.hibernate.study.id.union.xml;
/**
* @author 叶林生 
* @date：2017年7月13日 下午9:43:39
* @version 1.0
* 
*/
public class Student {
	
	private StudentPK pk;
	
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public StudentPK getPk() {
		return pk;
	}
	public void setPk(StudentPK pk) {
		this.pk = pk;
	}
}
