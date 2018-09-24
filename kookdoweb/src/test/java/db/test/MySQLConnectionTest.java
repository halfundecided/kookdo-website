package db.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MySQLConnectionTest {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/example?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PW = "pass123";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try{
			Connection con = DriverManager.getConnection(URL, USER, PW);
			System.out.println("11");
			System.out.println(con);
		}catch (Exception e) {
			System.out.println("에러");
			e.printStackTrace();
		}
	}
	
}
