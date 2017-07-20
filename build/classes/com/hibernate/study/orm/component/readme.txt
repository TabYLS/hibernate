组件映射是表示一个类当作另外一个类的属性，在数据库中只会生成一个表
如果被嵌入进来的类和本类当中存在冲突
1.在xml中的property加上映射就可以

2.在注解中当被嵌入的对象当中包含着有和其本类当中有属性名字冲突的时候可以使用下面的注解类解决，也可以在被嵌入的对象的属性的getter方法里面加上@Column
	 *  @AttributeOverrides({
            @AttributeOverride(name="iso2", column = @Column(name="bornIso2") ),
            @AttributeOverride(name="name", column = @Column(name="bornCountryName") )
    	})