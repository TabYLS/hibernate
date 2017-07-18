package com.hibernate.study.core.threeStatus.update;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;
/**
* @author 叶林生 
* @date：2017年7月18日 下午10:56:34
* @version 1.0
* 
*/

public class Update {
	//先获取，再更新，会将session中的所有信息全部重新再更新一遍，detached状态可以更新（会全部更新，效率低）
	@Test
	public void testUpdate1() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		//先获取，
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 1);
		session.getTransaction().commit();
		//进入detached状态
		t.setName("zhanglaoshi");
		//再更新
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.update(t);
		
		session2.getTransaction().commit();
	}
	
	//transient状态下的内容也能更新到数据库中，但是，需要指定id
	@Test
	public void testUpdate2() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Teacher t = new Teacher();
		t.setName("zhanglaoshi");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.update(t);//在transient状态下更新，没有指定id,更新失败
		session2.getTransaction().commit();
	}
	
	//transient状态下的内容也能更新到数据库中，但是，需要指定id（会全部更新，效率低）
	@Test
	public void testUpdate3() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("zhanglaoshi");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.update(t);//在transient状态下更新，指定id,更新成功
		
		session2.getTransaction().commit();
	}
	
	//查询出来，做了修改，再做提交，不主动update也能实现更新，
	//当发现session中的数据和数据库中的不一致的时候，会将session中的数据更新到数据库中（会全部更新，效率低）
	//这种情况和以上的情况有所不同，这种方式如果发现session中的数据和数据库中的一致就不会发执行更新，
	//但是更新的时候就会更新全部字段,以上的不管是否相同，都会更新
	@Test
	public void testUpdate4() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 1);
		t.setName("zhangsan12122");
		session.getTransaction().commit();
	}
	
	public void testUpdate5(){
		/**
		 * 这中做法是在实体类对象中的属性或者属性对应的getter方法当中
		 * 加入一个注解：@Column(updatable=false)这样就可以将指定属性不更新，xml中的话只需要在property当中加入  update="true|false"即可
		 * 但是这种做法缺乏灵活性，对于经常更变的需求会不能够灵活处理
		 */
	}
	
	//基于xml的方式，在class中加入一个dynamic-update="true"即可
	//对于persistent和数据库中的相同的时候就不会发出sql语句
	//但是这种方式对于跨越session的时候就，第二个session就会更新所有的字段
	//对于这个现象出现的原因是：
	/**
	 * 第一个session提交关闭之后，对象进入了detached状态，
	 * 第二个session获取到detached状态的对象，在执行update的时候由于缓存当中没有与之相比较的内容，所以会直接更新
	 * 
	 */
	@Test
	public void testUpdate6() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student s = (Student)session.get(Student.class, 1);
		s.setName("zhangsan66");
		session.getTransaction().commit();
		
		s.setName("z4");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.update(s);
		session2.getTransaction().commit();
	}
	
	//这种方式对第六种方式的改进，同时也是要在xml文件中配置的
	//这种方式可以实现跨越session的时候第二个也会只是更新指定的字段
	/**
	 * 原因分析：
	 * 因为merge(s)操作的时候会执行一下查询的操作（可以在日志中看到），所以可以让session缓存中有了可以比较的对象，
	 * 从而可以实现跨session的时候也可以更新指定字段
	 * 
	 */
	@Test
	public void testUpdate7() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Student s = (Student)session.get(Student.class, 1);
		s.setName("zhangsan6");
		session.getTransaction().commit();
		
		s.setName("z4");
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		session2.merge(s);
		session2.getTransaction().commit();
	}
	
	//建议使用这种方式进行更新HQL语句
	//面向对象的方式
	@Test
	public void testUpdate8() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//update中的不是表，而是对象，所以它是一个类名，而不是一个表名
		Query q = session.createQuery("update Teacher t set t.name='z5666' where t.id = 1");
		int flag = q.executeUpdate();//在数据库中执行成功返回1，失败返回0
		System.out.println(flag);
		session.getTransaction().commit();
		
	}
}
