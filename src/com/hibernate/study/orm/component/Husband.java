package com.hibernate.study.orm.component;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
* @author 叶林生 
* @date：2017年7月19日 下午8:13:04
* @version 1.0
* 
*/
@Entity
public class Husband {
	
	private int id;
	private String name;
	private Wife wife;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	//表示下面的那个对象是作为一个对象给嵌入进来的
	@Embedded
	/*	当被嵌入的对象当中包含着有和其本类当中有属性名字冲突的时候可以使用下面的注解类解决，也可以在被嵌入的对象的属性的getter方法里面加上@Column
	 *  @AttributeOverrides({
            @AttributeOverride(name="iso2", column = @Column(name="bornIso2") ),
            @AttributeOverride(name="name", column = @Column(name="bornCountryName") )
    	})
	 * 
	 */
	public Wife getWife() {
		return wife;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}

}
