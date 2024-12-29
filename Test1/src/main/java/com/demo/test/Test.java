package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
	
	    public static void main(String[] args) throws SQLException {
	        String jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // Update with your actual details
	        String username = "MYAPP";  // Your Oracle DB username
	        String password = "myapp@123";  // Your Oracle DB password

	        // SQL INSERT query
	        String sql = "INSERT INTO users (user_id, first_name, phone) VALUES (?, ?, ?)";

	        // Connection object
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            Class.forName("oracle.jdbc.OracleDriver");

	            connection = DriverManager.getConnection(jdbcUrl, username, password);
	            System.out.println("Connected to Oracle 11g Database successfully!");

	         
	            preparedStatement = connection.prepareStatement(sql);
	            
	            // Set values for the INSERT statement
	            preparedStatement.setInt(1, 101); // user_id
	            preparedStatement.setString(2, "John"); // first_name
	            preparedStatement.setString(5, "1234567890"); // phone

	            // Execute the query
	            int rowsAffected = preparedStatement.executeUpdate();
	            
	            if (rowsAffected > 0) {
	                System.out.println("Registration details added successfully!");
	            } else {
	                System.out.println("Failed to add registration details.");
	            }

	        } catch (ClassNotFoundException e) {
	            System.out.println("Oracle JDBC Driver not found!");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Error while interacting with the database!");
	            e.printStackTrace();
	        } finally {
	                    connection.close();
	                    System.out.println("Connection closed.");
	                }
	            } 
	        
	    
}