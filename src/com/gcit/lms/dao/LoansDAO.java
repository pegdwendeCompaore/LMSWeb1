package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.*;

public class LoansDAO extends BaseDAO{

	public LoansDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void checkOut(Loans l) throws SQLException  {
		try {
			save("insert into tbl_book_loans (bookId, branchId , cardNo, dateOut, dueDate, dateIn) values (?,?,?, curdate(),DATE_ADD(curdate(),INTERVAL 7 DAY),null)  ",
					new Object[] { l.getBookId() , l.getBranchId(), l.getCardNo() });
		} catch (SQLException e) {
			
		//	save("Update tbl_book_loans set dateOut = curdate(), dueDate = DATE_ADD(curdate(),INTERVAL 7 DAY), dateIn=null where bookId =? and branchId=? and cardNo=? ",
					//new Object[] { l.getBookId() , l.getBranchId(), l.getCardNo() });
			//e.printStackTrace();
		}
	}
	public void overWrite(Loans l) throws SQLException  {
		try {
			save("Update tbl_book_loans set dueDate = DATE_ADD(dueDate,INTERVAL 7 DAY)  where bookId =? and branchId=? and cardNo=? and dateIn is null",
					new Object[] { l.getBookId() , l.getBranchId(), l.getCardNo() });
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
	}
	public void Return(Loans l) throws SQLException {
		save("Update tbl_book_loans set dateIn = curdate() where bookId =? and branchId=? and cardNo=? ",
				new Object[] { l.getBookId() , l.getBranchId(), l.getCardNo() });
		
	}

	@Override
	public <T> List<T> extractData(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> extractDataFirstLevel(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
