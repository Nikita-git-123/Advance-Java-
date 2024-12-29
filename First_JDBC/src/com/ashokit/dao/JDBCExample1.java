package com.ashokit.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.ashokit.dto.Employee;

public class JDBCExample1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		con = JDBCConnection.getConnection();
	}
	
}
