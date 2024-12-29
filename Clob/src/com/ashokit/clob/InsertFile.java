package com.ashokit.clob;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class InsertFile {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
		
		Connection connection = JDBCConnection3.GetConnection();
		PreparedStatement statement = connection.prepareStatement("select * from File1 where id=?");
		statement.setInt(1, 2);
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		System.out.println("Id : " + resultSet.getInt(1));
		System.out.println("File : " + resultSet.getClob(2));
		connection.close();
		System.out.println("Executed");
		
		
		//PreparedStatement statement = connection.prepareStatement("create table File1(id number(5), Doc clob)");
		
		
		/*PreparedStatement statement = connection.prepareStatement("insert into File1 values(?, ?)");
		statement.setInt(1,2);
		
		FileReader fis = new FileReader("D:\\Images\\Try.txt");
		statement.setClob(2, fis);
		
		int executeUpdate = statement.executeUpdate();
		System.out.println(executeUpdate);
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		connection.close();
		System.out.println("Executed");
		*/
	}

}
