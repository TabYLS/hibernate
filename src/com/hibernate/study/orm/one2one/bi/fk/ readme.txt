一对一的双向外键关联
学习使用注解即可
在BiHusband中引用BiWife，在BiWife中引用BiHusband，并且都加上注解@OneToOne
但是在BiWife中的@OneToOne加上了mappedBy="wife"，表示BiWife和BiHusband已经是一对一的外键关联关系，但是呢外键的关联是在BiHusband哪里的getWife那里做的
	@OneToOne(mappedBy="wife")
	public BiHusband getHusband() {
		return husband;
	}
	解读：
	@OneToOne：和BiHusband一对一关联（因为BiHusband也做了和BiWife的一对一所以这里就是一对一的双向关联），
	mappedBy="wife"：映射外键关系到BiHusband中的getWife方法上面去
	
	

在xml中的使用：
	在Studentxml中加入<one-to-one name="stuIdCard" property-ref="student"/>
	在StudentIdCard的xml文件中加入<many-to-one name="student" unique="true" column="studentId"/>即可实现做一对一的双向关联映射