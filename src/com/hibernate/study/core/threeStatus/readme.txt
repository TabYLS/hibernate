2	三种状态的区分关键在于
	a)	有没有ID
	b)	ID在数据库中有没有
	c)	在内存中有没有（session缓存）
3	三种状态：
	a)	transient：内存中一个对象，没ID,缓存中也没有
	b)	persistent：内存中有，缓存中有，数据库有（ID) 
	c)	detached：内存有，缓存没有，数据库有，ID
	
	
=====================================================================================
						不管是三种状态还是增删改查都应该围绕id
======================================================================================
	1.删除的时候应该注意的问题
	添加数据的时候加上这个配置不会报错，<property name="hbm2ddl.auto">create</property>
	但是在删除的时候如果加上了这个就会报错，因为它会新建表，所有会把原来的数据给清除掉
	然后报异常：org.hibernate.StaleStateException: Batch update returned unexpected row count from update [0]; actual row count: 0; expected: 1
