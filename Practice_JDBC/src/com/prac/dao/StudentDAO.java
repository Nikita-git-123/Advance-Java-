package com.prac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	public static Connection ConnectionJDBC() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver is registered");
		
		String url = "jdbc:oracle:thin:@127.0.1:1521:xe";
		Connection con = DriverManager.getConnection(url, "system", "patil2020");
		System.out.println("Connection is established");
		return con;
	}
	
    public static void insertStudent(Student stud) throws SQLException, ClassNotFoundException {
		
		Connection con = null;
		Statement createState = null;
		
		try {
			con = StudentDAO.ConnectionJDBC();
			
			createState = con.createStatement();
			System.out.println("Statement object is created");
			
			String sql = "insert into studDetails values("+"'"+stud.getStudName()+"'"+","+stud.getStudPRN()+","+"'"+stud.getStudCourse()+"'"+")";
			createState.execute(sql);
			System.out.println("Insert is successful");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			createState.close();
			con.close();
		}
	}
    
    public static void deleteStudent(Student stud) throws SQLException, ClassNotFoundException {
		
		Connection con = null;
		Statement createState = null;
		
		try {
			con = StudentDAO.ConnectionJDBC();
			
			createState = con.createStatement();
			System.out.println("Statement object is created");
			
			String sql = "delete from studDetails where studPRN=("+stud.getStudPRN()+")";
			createState.execute(sql);
			System.out.println("Delete is successful");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			createState.close();
			con.close();
		}
	} 
    
    public static List<Student> getStudent(Integer id) throws SQLException, ClassNotFoundException {
 		
		Connection con = null;
		Statement createState = null;
		List<Student> studentList = new ArrayList<>();
		
		try {
			con = StudentDAO.ConnectionJDBC();
			
			createState = con.createStatement();
			System.out.println("Statement object is created");
			
			String sql = "select * from studDetails where studPrn=" + id;
			ResultSet resultSet = createState.executeQuery(sql);
			
			while(resultSet.next()) {
				String studname = resultSet.getString(1);
				int studid = resultSet.getInt(2);
				String studcourse = resultSet.getString(3);
				Student student = new Student();
				student.setStudName(studname);
				student.setStudPRN(studid);
				student.setStudCourse(studcourse);
				studentList.add(student);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			createState.close();
			con.close();
		}
		
		return studentList;
	} 

}
