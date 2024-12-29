package com.prac.dao;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		List<Student> student = StudentDAO.getStudent(101);
		System.out.println(student);
		
	}
}
