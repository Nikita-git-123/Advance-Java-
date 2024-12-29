package com.ashokit.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch {
	
	/*
	public static void createBatch() throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCConnection5.GetConnection();
		Statement state = con.createStatement();
		String sql = "create table emp_details(empid number(5), empname varchar2(7), empsalary number(8))";
        state.execute(sql);
        System.out.println("Table created successfully...........");
	}
    */
	
    public static void insertBatchPS() throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCConnection5.GetConnection();
		String sql = "insert into emp_details values(?, ?, ?)";
		PreparedStatement state = con.prepareStatement(sql);
		
		state.setInt(1, 105);
		state.setString(2, "Kundan");
		state.setInt(3, 50000);
		state.addBatch();
		
		state.setInt(1, 106);
		state.setString(2, "Jyoti");
		state.setInt(3, 60000);
		state.addBatch();
		
		state.setInt(1, 107);
		state.setString(2, "Gopi");
		state.setInt(3, 70000);
		state.addBatch();
		
		state.executeBatch();
        System.out.println("Record inserted successfully...........");
	}
}
