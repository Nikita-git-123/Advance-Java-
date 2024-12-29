package com.ashokit.batch;

import java.sql.Connection;
import java.sql.SQLException;

public class BatchTest1 {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Batch.createBatch();
		Connection connection = JDBCConnection4.GetConnection();
		try {
			Batch1.insertBatchS();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			connection.close();
		}
	}

	
}
