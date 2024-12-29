package com.ashokit.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.ashokit.dto.ResultDTO;

public class ResultTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		List<ResultDTO> result = ResultDAO.getResult(110022);
		System.out.println(result);
		
		/*ResultDTO resultdto = new ResultDTO();
		ResultDAO.insertResultWithPreparedStatement(resultdto);
		Set<ResultDTO> resultdto1 = ResultDAO.getResult();
		System.out.println(resultdto1);
		*/
		
	}

}
