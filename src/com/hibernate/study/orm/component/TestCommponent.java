package com.hibernate.study.orm.component;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
* @author 叶林生 
* @date：2017年7月20日 下午3:42:24
* @version 1.0
* 
*/
public class TestCommponent {
	
	@Test
	public void schemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
	}

}
