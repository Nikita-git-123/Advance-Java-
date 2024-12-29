package com.meta.dao;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MetaData1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCConnection1.GetConnection();
		PreparedStatement psmt= 	con.prepareStatement("select * from PSStudentResult where seatno=?");
		ParameterMetaData pmd = psmt.getParameterMetaData();
		System.out.println(pmd.getParameterCount());
	}
}
