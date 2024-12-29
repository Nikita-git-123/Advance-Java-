
package com.servlet.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
public static Connection getConnection(String dbusername,String dbuserpass) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver is registered.");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con = DriverManager.getConnection(url, dbusername, dbuserpass);
		System.out.println("Connection is established");
		return con;
	}

}
