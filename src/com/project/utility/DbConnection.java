package com.project.utility;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection con=null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplaza",   "root","root");
			return con;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return con;
		
	}

}
