package com.hibernate.study.orm.component.xml;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
* @author 叶林生 
* @date：2017年7月13日 下午9:44:21
* @version 1.0
* 
*/
public class StudentTest {
	
	@Test
	public void schemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
	}

}
