package com.meta.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class MetaData3 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCConnection1.GetConnection();
		DatabaseMetaData dbmd = con.getMetaData();
		System.out.println("Driver name :" + dbmd.getDriverName());
		System.out.println("Driver Version :" + dbmd.getDriverVersion());
		System.out.println("User Name :" + dbmd.getUserName());
		System.out.println("URL Name :" + dbmd.getURL());
		
	}

}
