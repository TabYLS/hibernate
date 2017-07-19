一对一单向外键关联
这里的实验是做注解的方式：基于xml的方式比较麻烦，所以不做实验了只要用个标签：注意使用unique="true"
<many-to-one name="person" column="personId" not-null="true" unique="true"/>