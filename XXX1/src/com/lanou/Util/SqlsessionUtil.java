package com.lanou.Util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lanou.bean.Admin;


public class SqlsessionUtil {
	
	
	public static <t> Object get(Class<t> c) {
		Object o=null;
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession session =sqlSessionFactory.openSession(true);
			o=session.getMapper(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
}
