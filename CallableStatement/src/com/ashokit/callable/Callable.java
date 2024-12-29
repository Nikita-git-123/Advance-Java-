package com.ashokit.callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Callable {
	
	public static void main(String[] args ) throws ClassNotFoundException, SQLException {
		
		Connection con = JDBCConnection6.GetConnection();
		CallableStatement callable = con.prepareCall("{call myproc(?, ?, ?) }");
		callable.setInt(1, 108);
		callable.setString(2, "Nikita");
		callable.setInt(3, 50000);
		callable.execute();
		con.close();
		System.out.println("Callable Statement successfull............");
	}

}
