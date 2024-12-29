/*
 * This program is about inserting record with statement object and with batch object.
 */
package com.ashokit.batch;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch1 {
	
	public static void createBatch() throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCConnection4.GetConnection();
		Statement state = con.createStatement();
		String sql = "create table emp_details(empid number(5), empname varchar2(7), empsalary number(8))";
        state.execute(sql);
        System.out.println("Table created successfully...........");
	}
	
    public static void insertBatchS() throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCConnection4.GetConnection();
		Statement state = con.createStatement();
		state.addBatch("insert into emp_details values(101, 'Nikita', 10000)");
		state.addBatch("insert into emp_details values(102, 'Namrata', 20000)");
		state.addBatch("insert into emp_details values(103, 'Poonam', 30000)");
		state.addBatch("insert into emp_details values(104, 'Kavita', 40000)");
		state.executeBatch();
        System.out.println("Record inserted successfully...........");
	}

}
