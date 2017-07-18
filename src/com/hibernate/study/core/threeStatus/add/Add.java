package com.hibernate.study.core.threeStatus.add;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
* @author 叶林生 
* @date：2017年7月18日 下午10:35:20
* @version 1.0
* 
*/

public class Add {
	@Test
	public void add() {
		Teacher teacher = new Teacher();
		teacher.setName("teahcer2");
		teacher.setTitle("高级");
		
		Teacher teacher2 = new Teacher();
		teacher2.setName("teahcer222222222");
		teacher2.setTitle("高级2222222222");
		
		Configuration cfg = new AnnotationConfiguration();
		System.out.println("..........................Before SessionFactory...................");
		//cfg.configure()不加参数默认在classpath下面找到hibernage.cfg.xml
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		System.out.println("................................Before Session.....................");
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(teacher);
		session.save(teacher2);
		System.out.println(teacher.getId());
		session.getTransaction().commit();
	}
}
