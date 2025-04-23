package com.gyshop.main.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTests {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gyshop", "java", "java")){
			log.info(con);
		} catch (Exception e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
}
