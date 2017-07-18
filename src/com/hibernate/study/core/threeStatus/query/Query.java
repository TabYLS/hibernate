package com.hibernate.study.core.threeStatus.query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

/**
* @author 叶林生 
* @date：2017年7月18日 下午10:53:37
* @version 1.0
* 
*/

public class Query {
	//load返回的是代理对象，等到真正用到对象的内容时才发出sql语句
	//load方法是使用的代理方式，是延迟加载，就是在teacher.getName()取值的时候才会发送sql语句,这个可以在控制台上的打印日志可以看到，在没有取至的时候，控制它不会打印出sql语句
	//所以在session关闭之后再使用teacher.getName()来获取值的话会报错：org.hibernate.LazyInitializationException: could not initialize proxy - no Session
	@Test
	public void load() {
		Teacher teacher = null;
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//参数说明：第一个参数是指，从数据库中查询出来的数据应该封装成什么样的类型
		//		   ：第二个参数是指主键，而且应该是实现了Serializable接口的
		teacher = (Teacher) session.load(Teacher.class, 1);//这里第二个参数可以直接用1是因为int类型可以自动封装，Integer类型是实现了Serializable接口的
		System.out.println(teacher.getName());
		session.getTransaction().commit();
		//在使用的时候才发送sql语句
		//System.out.println(teacher.getName());
		//打印出来的是代理对象（Teacher的代理）
		System.out.println(teacher.getClass().getName());
	}
	//get直接从数据库加载，不会延迟
	@Test
	public void get() {
		Teacher teacher = null;
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//参数说明：第一个参数是指，从数据库中查询出来的数据应该封装成什么样的类型
		//		   ：第二个参数是指主键，而且应该是实现了Serializable接口的
		teacher = (Teacher) session.get(Teacher.class, 1);//这里第二个参数可以直接用1是因为int类型可以自动封装，Integer类型是实现了Serializable接口的
		System.out.println(teacher.getName());
		session.getTransaction().commit();
		//直接从数据库加载，不会延迟
		System.out.println(teacher.getName());
		//打印出来的是Teacher的对象
		System.out.println(teacher.getClass().getName());
	}
}
