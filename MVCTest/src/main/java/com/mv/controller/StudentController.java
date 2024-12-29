package com.mv.controller;

import com.mvc.model.StudentModel;
import com.mvc.view.StudentView;

public class StudentController {
	
	StudentModel studentModel;
	StudentView studentView;
	
	
	public StudentController(StudentModel studentModel, StudentView studentView) {
		this.studentModel = studentModel;
		this.studentView = studentView;
	}
	
	public StudentModel getStudentModel() {
		return studentModel;
	}

	public void setStudentModel(StudentModel studentModel) {
		this.studentModel = studentModel;
	}

	public StudentView getStudentView() {
		return studentView;
	}

	public void setStudentView(StudentView studentView) {
		this.studentView = studentView;
	}

	public void callView() {
		studentView.printStudentDetails(studentModel.getName(), studentModel.getRollNo(), studentModel.getDepartment()); 
	}
	
	

}
