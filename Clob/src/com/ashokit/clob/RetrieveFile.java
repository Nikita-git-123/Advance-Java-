package com.ashokit.clob;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveFile {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		
		Connection connection = JDBCConnection3.GetConnection();
		PreparedStatement statement = connection.prepareStatement("select * from File1 where id=?");
		statement.setInt(1, 1);
		ResultSet resultSet = statement.executeQuery();
		Clob clob = null;
		if(resultSet.next())
			clob = resultSet.getClob(2);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\Retrieve\\Text1.txt");
		Reader characterStream = clob.getCharacterStream();
		int i=0;
		while( (i=characterStream.read())!=-1) {
			System.out.println(i);
			fileWriter.write(i);
		}
		fileWriter.close();
		connection.close();
		System.out.println("File is Retrieved");
	}

}
