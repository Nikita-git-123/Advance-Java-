package com.ashokit.callreturn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class CallableReturnTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection oracleConnection = JDBCConnection7.GetConnection();
		CallableStatement callableStatement = oracleConnection.prepareCall("{?=call Sum1(?,?)}");
		
		callableStatement.setInt(2, 10);
		callableStatement.setInt(3, 20);
		
		callableStatement.registerOutParameter(1, Types.INTEGER);
		callableStatement.execute();
		
		int result = callableStatement.getInt(1);
		System.out.println("Result :"+result);
		
		oracleConnection.close();
		System.out.println("Success");
	}

}
