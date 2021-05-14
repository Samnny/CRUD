package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/db_projeto?useTimezone=true&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "121104";
	
	public static Connection getConnection() {
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException();
			
		}
	}
}
