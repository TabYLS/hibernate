package com.hibernate.study.core.threeStatus.basicMethod;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;


/**
* @author 叶林生 
* @date：2017年7月19日 上午10:24:12
* @version 1.0
* 
*/
public class BasicMethod {
	
	@Test
	public void saveOrUpdate() {
		
		Teacher teacher = new Teacher();
		teacher.setName("save or update");
		teacher.setTitle("save or update title!");
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(teacher);
		session.getTransaction().commit();
		
		teacher.setName("save or update change");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.saveOrUpdate(teacher);
		session2.getTransaction().commit();
	}
	
	//clear方法清空缓存，如果没有加入session.clear()方法则在第二次load对象的的时候就不会再次发出sql语句从数据库中查询
	//如果在第一次sessio获取到对象并且也使用了这个对象之后加入session.clear()方法清空缓存，
	//所以第二次session获取对象并且使用的时候会再次发出sql语句
	@Test
	public void clear1() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher teacher = (Teacher) session.load(Teacher.class, 1);
		System.out.println(teacher.getName());
		
		session.clear();//加入了这行代码，下面的load的对象也会发出sql语句
		
		Teacher teacher2 = (Teacher) session.load(Teacher.class, 1);
		System.out.println(teacher2.getName());
		session.getTransaction().commit();
	}
	//上面测试load方法，这测试get方法
	@Test
	public void clear2() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher teacher = (Teacher) session.get(Teacher.class, 1);
		System.out.println(teacher.getName());
		
		session.clear();//加入了这行代码，下面的load的对象也会发出sql语句
		
		Teacher teacher2 = (Teacher) session.get(Teacher.class, 1);
		System.out.println(teacher2.getName());
		session.getTransaction().commit();
	}
	
	@Test
	public void flush() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Teacher teacher = (Teacher) session.get(Teacher.class, 1);
		System.out.println(teacher.getName());
		teacher.setName("改改啊");
		//如果这里没有flush的话，那么虽然修改了两次，但是也只会发出一次sql语句到数据库中
		//分析：不管做多少次修改，修改的都是缓存当中的，所以如果没有提交事物的话是不会把数据更新到数据库中的
		session.flush();
		//session.clear();
		teacher.setName("再改改啊");
		System.out.println(teacher.getName());
		
		session.getTransaction().commit();
	}

}
