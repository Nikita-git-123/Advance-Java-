package com.test.oraclejdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
	
	public static Connection GetConnection() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("java.sql.Driver");		
		//Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver is registered.");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/nikudb", "root", "Patil-2020");
		//Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MYAPP", "myapp@123");
		System.out.println("Connection is established...........");
		return connection;
	}

}
