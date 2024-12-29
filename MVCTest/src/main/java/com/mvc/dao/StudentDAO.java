package com.mvc.dao;

import com.mvc.model.StudentModel;

public class StudentDAO {
	
	public static StudentModel getResultFormDB() {
		
		StudentModel studentModel = new StudentModel();
		studentModel.setName("Nikita");
		studentModel.setRollNo("101");
		studentModel.setDepartment("Information technology");
		return studentModel;
		
		
		
	}
 }
