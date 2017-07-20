一对一的双向主键关联
注解会出问题
实验使用xml，不重要，只需了解即可
在Student.hbm.xml中加入：<one-to-one name="stuIdCard" property-ref="student"></one-to-one>
在StudentIdCard.hbm.xml中加入：<one-to-one name="student" constrained="true"></one-to-one>