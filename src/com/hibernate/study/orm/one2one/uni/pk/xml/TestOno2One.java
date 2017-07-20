package com.hibernate.study.orm.one2one.uni.pk.xml;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
* @author 叶林生 
* @date：2017年7月19日 下午8:24:43
* @version 1.0
* 
*/
public class TestOno2One {
	
	private Session session = null;
	
	//@BeforeClass
	public void beforeClass() {
		session = new AnnotationConfiguration().configure().buildSessionFactory().getCurrentSession();
		session.getTransaction();
	}
	
	public void one2one() {
		
	}
	
	//使用这个可以用程序帮助我们建表
	@Test
	public void schemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
	}
	
	//@AfterClass
	public void afterClass() {
		session.getTransaction().commit();
	}

}
