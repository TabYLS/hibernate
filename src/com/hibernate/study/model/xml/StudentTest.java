package com.hibernate.study.model.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
* @author 叶林生 
* @date：2017年7月13日 下午9:44:21
* @version 1.0
* 
*/
public class StudentTest {
	
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setId(1);
		stu.setName("s1");
		stu.setAge(1);
		
		//既有注解又有配置文件，应该使用AnnotationConfiguration
		//Configuration cfg = new Configuration();
		
		Configuration cfg = new AnnotationConfiguration();
		//cfg.configure()不加参数默认在classpath下面找到hibernage.cfg.xml
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(stu);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
