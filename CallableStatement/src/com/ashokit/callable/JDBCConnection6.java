package com.ashokit.callable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ashokit.callable.JDBCConnection6;

public class JDBCConnection6 {
	
	private static Connection connection;

	private JDBCConnection6() {
	}

	public static Connection GetConnection() throws ClassNotFoundException, SQLException {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			if (connection == null) {
				synchronized (JDBCConnection6.class) {
					if (connection == null) {
						connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system","patil2020");
						System.out.println("Connection is established");
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}

}
