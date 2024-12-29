package com.ashokit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PSStudentDAO {
	//private static Connection connection = null;
	
	//private PSStudentDAO() {}
	
	/*public static Connection GetConnection() throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			if(connection == null) {
				connection= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "patil2020");
			System.out.println("Connection is established");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return connection;
	}
	*/
	
	public static void createTablePS() throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		Statement statement = null;
		con = JDBCConnection.GetConnection();
		statement = con.createStatement();
		String sql = "create table PSStudentResult(seatno number(6), name varchar2(10), surname varchar2(10), dob number(6), grade varchar2(2), points number(2))";
		statement.execute(sql);
		System.out.println("Created successfully....");
	}
	
	public static void insertResultPS() throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		PreparedStatement preparedstatement = null;
		con = JDBCConnection.GetConnection();
		con.setAutoCommit(false);
		String sql = "insert into PSStudentResult values(?,?,?,?,?,?)";
		preparedstatement = con.prepareStatement(sql);
		preparedstatement.setInt(1, 1009);
		preparedstatement.setString(2, "Namrata");
		preparedstatement.setString(3, "Patil");
		preparedstatement.setInt(4, 260405);
		preparedstatement.setString(5, "A");
		preparedstatement.setInt(6, 9);
		preparedstatement.execute();
		
		preparedstatement.setInt(1, 1010);
		preparedstatement.setString(2, "Kundan");
		preparedstatement.setString(3, "Patil");
		preparedstatement.setInt(4, 180809);
		preparedstatement.setString(5, "A");
		preparedstatement.setInt(6, 9);
		preparedstatement.execute();
		
		System.out.println("Inserted successfully....");	
	}
	
    public static void updateResultPS() throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		PreparedStatement preparedstatement = null;
		con = JDBCConnection.GetConnection();
		String sql = "update PSStudentResult set name=?, surname=?, dob=?, grade=?, points=? where seatno=?";
		preparedstatement = con.prepareStatement(sql);
		preparedstatement.setString(1, "Poonam");
		preparedstatement.setString(2, "Bagul");
		preparedstatement.setInt(3, 140784);
		preparedstatement.setString(4, "A");
		preparedstatement.setInt(5, 10);
		preparedstatement.setInt(6, 1002);
		preparedstatement.executeUpdate();
		
		preparedstatement.setString(1, "Akshita");
		preparedstatement.setString(2, "Tambe");
		preparedstatement.setInt(3, 260202);
		preparedstatement.setString(4, "A");
		preparedstatement.setInt(5, 10);
		preparedstatement.setInt(6, 1007);
		preparedstatement.executeUpdate();
		System.out.println("Updated successfully....");
		
	}
    
    public static void deleteResultPS() throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		PreparedStatement preparedstatement = null;
		con = JDBCConnection.GetConnection();
		String sql = "delete from PSStudentResult where seatno=?";
		preparedstatement = con.prepareStatement(sql);
		preparedstatement.setInt(1, 1008);
		preparedstatement.execute();
		System.out.println("Deleted successfully....");
	}
    
    public static void selectResultPS() throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		PreparedStatement preparedstatement = null;
		con = JDBCConnection.GetConnection();
		String sql = "select * from PSStudentResult where seatno=?";
		preparedstatement = con.prepareStatement(sql);
		preparedstatement.setInt(1, 1003);
		ResultSet resultSet = preparedstatement.executeQuery();
		resultSet.next();
		
		System.out.println("Seat No : " + resultSet.getInt(1));
		System.out.println("Name : " + resultSet.getString(2));
		System.out.println("Surname : " + resultSet.getString(3));
		System.out.println("DOB : " + resultSet.getInt(4));
		System.out.println("Grade : " + resultSet.getString(5));
		System.out.println("Points : " + resultSet.getInt(6));
		
		System.out.println("Retrived successfully....");
		
			
		}
		
}


