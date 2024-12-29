package com.demo.mvcpattern;

import com.mv.controller.StudentController;
import com.mvc.dao.StudentDAO;
import com.mvc.model.StudentModel;
import com.mvc.view.StudentView;

public class MVCPattern {

	public static void main(String[] args) {
		
		StudentModel studentModel = StudentDAO.getResultFormDB();
		StudentView studentView = new StudentView();
		
		StudentController studentController = new StudentController(studentModel, studentView);
		studentController.callView();
	}

}
