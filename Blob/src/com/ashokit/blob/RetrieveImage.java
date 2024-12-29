package com.ashokit.blob;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveImage {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
		
		Connection connection = JDBCConnection2.GetConnection();
		PreparedStatement statement = connection.prepareStatement("select * from Image where id=?");
		statement.setInt(1, 1);
		ResultSet resultSet = statement.executeQuery();
		Blob blob = null;
		if(resultSet.next())
			blob = resultSet.getBlob(2);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\Retrieve\\Image1.jpg");
		byte[] bytes = blob.getBytes(1, (int)blob.length());
		
		try {
			fos.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Retrieve is successfull");
		connection.close();
		
	}

}
