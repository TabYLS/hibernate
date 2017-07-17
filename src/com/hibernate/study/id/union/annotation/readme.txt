联合主键基于annotation的配置方式，它有三种方式进行配置
1.将组件类注解为@Embeddable,并将组件的属性注解为@Id
2.将组件的属性注解为@EmbeddedId
3.将类注解为@IdClass,并将该实体中所有属于主键的属性都注解为@Id
这里选用比较适用的方式也就是第三种适合编程习惯的。
请参考：http://www.cnblogs.com/lcngu/p/5854864.html