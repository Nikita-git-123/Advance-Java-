package com.ashokit.blob;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertImage {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		
		Connection connection = JDBCConnection2.GetConnection();
	
		//PreparedStatement statement = connection.prepareStatement("create table Image(id number(5), image blob)");
		PreparedStatement statement = connection.prepareStatement("insert into Image values(?, ?)");
		statement.setInt(1,1);
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Pictures\\Camera Roll\\WIN_20240813_15_08_11_Pro.jpg");
		statement.setBlob(2, fis);
		
		int executeUpdate = statement.executeUpdate();
		System.out.println(executeUpdate);
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		connection.close();
		System.out.println("Executed");

	}

}