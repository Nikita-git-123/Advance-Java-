package com.ashokit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ashokit.dto.ResultDTO;

public class ResultDAO {
	
	public static Connection ConnectionR() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver is registered.");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection con = DriverManager.getConnection(url, "MYAPP", "myapp@123");
		System.out.println("Connection is established.");
		
		return con;
	}
	
	public static void insertResult(ResultDTO resultdto) throws ClassNotFoundException, SQLException {
		
		Statement statement = null;
		Connection con = null;
		
		try {
			con = ResultDAO.ConnectionR();
			
			statement = con.createStatement();
			System.out.println("Statement is created.");
			
			String sql = "insert into StudentResult values("+resultdto.getSeatno()+","+"'"+resultdto.getName()+"'"+","+"'"+resultdto.getSurname()+"'"+","+resultdto.getDob()+","+"'"+resultdto.getGrade()+"'"+","+resultdto.getPoints()+")";
			statement.execute(sql);
			System.out.println("Insert is successfull....");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			statement.close();
			con.close();
		}	
	}
	
	
    public static void deleteResult(ResultDTO resultdto) throws ClassNotFoundException, SQLException {
		
		Statement statement = null;
		Connection con = null;
		
		try {
			con = ResultDAO.ConnectionR();
			
			statement = con.createStatement();
			System.out.println("Statement is created.");
			
			String sql = "delete from StudentResult where seatno=("+resultdto.getSeatno()+")";
			statement.execute(sql);
			System.out.println("Insert is successfull....");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			statement.close();
			con.close();
		}	
	}
    
    public static void updateResult(ResultDTO resultdto) throws ClassNotFoundException, SQLException {
		
		Statement statement = null;
		Connection con = null;
		
		try {
			con = ResultDAO.ConnectionR();
			
			statement = con.createStatement();
			System.out.println("Statement is created.");
			
			String sql = "update StudentResult set name="+"'"+resultdto.getName()+"'"+","+"surname="+"'"+resultdto.getSurname()+"'"+","+"dob="+resultdto.getDob()+","+"grade="+"'"+resultdto.getGrade()+"'"+","+"points="+resultdto.getPoints()+"where seatno ="+resultdto.getSeatno();
			statement.execute(sql);
			System.out.println("Insert is successfull....");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			statement.close();
			con.close();
		}	
	}
    
    public static List<ResultDTO> getResult(Integer seatno) throws ClassNotFoundException, SQLException {
		
		Statement statement = null;
		Connection con = null;
		List<ResultDTO> resultList = new ArrayList<>();
		
		try {
			con = ResultDAO.ConnectionR();
			
			statement = con.createStatement();
			System.out.println("Statement is created.");
			
			String sql = "select * from StudentResult where seatno=" + seatno;
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				int SeatNo = resultSet.getInt(1);
				String Name = resultSet.getString(2);
				String SurName = resultSet.getNString(3);
				int DOB = resultSet.getInt(4);
				String Grade = resultSet.getNString(5);
				int Points = resultSet.getInt(6);
				
				ResultDTO result = new ResultDTO();
				result.setSeatno(SeatNo);
				result.setName(Name);
				result.setSurname(SurName);
				result.setDob(DOB);
				result.setGrade(Grade);
				result.setPoints(Points);
				
				resultList.add(result);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			statement.close();
			con.close();
		}	
		
		return resultList;
	}
    
    /*public static void insertResultWithPreparedStatement(ResultDTO resultdto) throws ClassNotFoundException, SQLException {
		
		PreparedStatement preparedStatement = null;
		Connection con = null;
		
		try {
			con = ResultDAO.ConnectionR();
			
			String sql = "insert into StudentResult values(?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 110033);
			preparedStatement.setString(2, "Nikita");
			preparedStatement.setString(3, "Patil");
			preparedStatement.setInt(4, 140784);
			preparedStatement.setString(5, "A");
			preparedStatement.setInt(6, 9);
			preparedStatement.execute();
			
			System.out.println("Insert is successfull....");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			preparedStatement.close();
			con.close();
		}	
	}
    
    public static Set<ResultDTO> getResult() throws ClassNotFoundException, SQLException {
		
		Statement statement = null;
		Connection con = null;
		Set<ResultDTO> resultSet = new HashSet<>();
		
		try {
			con = ResultDAO.ConnectionR();
			
			statement = con.createStatement();
			System.out.println("Statement is created.");
			
			String sql = "select * from StudentResult ";
			ResultSet resultset = statement.executeQuery(sql);
			
			while(resultset.next()) {			
				ResultDTO result = new ResultDTO();
				result.setSeatno(resultset.getInt(1));
				result.setName(resultset.getString(2));
				result.setSurname(resultset.getNString(3));
				result.setDob(resultset.getInt(4));
				result.setGrade(resultset.getNString(5));
				result.setPoints(resultset.getInt(6));
				
				resultSet.add(result);
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			statement.close();
			con.close();
		}
		return resultSet;	
	}*/
    
}
