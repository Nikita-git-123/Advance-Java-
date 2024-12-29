package com.ashokit.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class TestPSStudentResult {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection connection = JDBCConnection.GetConnection();
		try {
			//PSStudentDAO.createTablePS();
			//PSStudentDAO.insertResultPS();
			PSStudentDAO.selectResultPS();
			//PSStudentDAO.updateResultPS();
			//PSStudentDAO.deleteResultPS();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			connection.close();
		}
		
	}

}
