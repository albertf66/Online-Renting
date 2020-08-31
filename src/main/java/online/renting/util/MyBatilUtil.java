package online.renting.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatilUtil {
	private static SqlSessionFactory sessionFactory;
	
	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("resources/mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sessionFactory;
	}
}
