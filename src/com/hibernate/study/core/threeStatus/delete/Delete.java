package com.hibernate.study.core.threeStatus.delete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
* @author 叶林生 
* @date：2017年7月18日 下午10:38:48
* @version 1.0
* 
*/

public class Delete {
	/**
	 * 下面这段代码如果删除了save这个方法的话，后面的删除也执行不成功，
	 * 因为删除也是需要制定id的，没有存入数据库的时候，
	 * 按照指定的id生成策略不会为对象生成id，id的默认值是java虚拟机给赋值的为0
	 */
	@Test
	public void delete() {
		Teacher teacher = new Teacher();
		teacher.setName("teahcer5555");
		teacher.setTitle("高级");
		//刚刚创建的时候是：Transient状态，在Transient状态因为没有id
		
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(teacher);
		//装入session：persistent状态；装入了session之后session和数据库中就有了id，此时就可以进行删除的操作
		System.out.println(teacher.getId());
		session.getTransaction().commit();
		//session close之后变成： detached状态，也可以进行删除，因为数据库中有id
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.delete(teacher);
		session2.getTransaction().commit();
	}
	
	//删除指定id的对象
	@Test
	public void delete2() {
		Teacher teacher = new Teacher();
		teacher.setId(2);
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.delete(teacher);
		session2.getTransaction().commit();
		 
	}
}
