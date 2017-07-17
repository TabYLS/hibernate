package com.hibernate.study.id.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
* @author 叶林生 
* @date：2017年7月15日 下午12:42:44
* @version 1.0
* 
*/
public class TeacherTest {
	
	public static void main(String[] args) {
		Teacher teacher = new Teacher();
		teacher.setName("teahcer2");
		teacher.setTitle("高级");
		
		Teacher teacher2 = new Teacher();
		teacher2.setName("teahcer222222");
		teacher2.setTitle("高级222222222222");
		
		Configuration cfg = new AnnotationConfiguration();
		//cfg.configure()不加参数默认在classpath下面找到hibernage.cfg.xml
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(teacher);
		session.save(teacher2);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
