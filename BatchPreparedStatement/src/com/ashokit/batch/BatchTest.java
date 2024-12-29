package com.ashokit.batch;

import java.sql.Connection;
import java.sql.SQLException;

public class BatchTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection connection = JDBCConnection5.GetConnection();
		
		try {
			Batch.insertBatchPS();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			connection.close();
		}
		
	}

}
