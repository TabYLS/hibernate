package com.hibernate.study.core.session;

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
		teacher.setId(1);
		teacher.setName("teahcer2");
		teacher.setTitle("高级");
		
		Configuration cfg = new AnnotationConfiguration();
		//cfg.configure()不加参数默认在classpath下面找到hibernage.cfg.xml
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(teacher);
		session.getTransaction().commit();
	}

}
