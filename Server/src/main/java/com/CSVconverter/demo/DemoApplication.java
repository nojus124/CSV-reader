package com.CSVconverter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String url = "jdbc:h2:~/test";
		String user = "sa";
		String password = "";
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM information_schema.tables WHERE table_name = 'PERSON' AND table_schema='PUBLIC'");
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					System.out.println("Table 'PERSON' already exists.");
				} else {
					System.out.println("Table 'PERSON' does not exist.");
					stmt.execute("CREATE TABLE PERSON (ID VARCHAR(255), NAME VARCHAR(255), EMAIL VARCHAR(255), PHONE VARCHAR(255))");
					System.out.println("Table created.");
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
