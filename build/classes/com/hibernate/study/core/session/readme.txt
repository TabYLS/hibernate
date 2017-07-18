Configuration:读取hibernate.cfg.xml配置文件，获得所有hibernate运行时的参数，初始化mapping中的Teacher对象等等，（可以从指定位置获取）
SessionFactory：SessionFactory接口负责初始化Hibernate。它充当数据存储源的代理，并负责创建Session对象。初步初始化，对于一些与数据库相关的资源初始化，比如载入驱动，初始化用户名和密码，创建表，为下一步提供需要的资源
session：应用程序和数据库的一次交互（会话）。在这个Session中，包含了一般的持久化方法（CRUD），而且，Session是一个轻量级对象（线程不安全），通常将每个Session实例和一个数据库事务绑定，也就是每执行一个数据库事务，都应该先创建一个新的Session实例

openSession和getCurrentSession方法
两种方法的区别如下：
（1）openSession每次打开都是新的Session，所以多次获取的Session实例是不同的，并且需要人为的调用close方法进行Session关闭。
（2）getCurrentSession是从当前上下文中获取Session并且会绑定到当前线程，第一次调用时会创建一个Session实例，如果该Session未关闭，后续多次获取的是同一个Session实例；事务提交或者回滚时会自动关闭Sesison，无需人工关闭。
使用getCurrentSession时，需要在配置文件中添加如下：
（1）如果使用的是本地事务（JDBC事务），管理事物的时候用的是Connection的事物（单独一个数据的管理事物），
<property name="current_session_context_class">thread</property>
（2）如果使用的是全局事务（JTA事务）jta一般用于分布式，分布式数据库中使用的上下文是jta来管理事物
<property name="current_session_context_class">jta</property>
（如果使用了spring就要将上下文转移到spring当中）