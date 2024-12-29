package com.meta.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData2 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCConnection1.GetConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select name,surname from PSStudentResult where seatno=1003");
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("Col Count:"+rsmd.getColumnCount());
		System.out.println("Col Name:"+rsmd.getColumnName(2));
	}

}
