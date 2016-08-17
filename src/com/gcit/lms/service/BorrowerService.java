package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.LoansDAO;
import com.gcit.lms.dao.*;
import com.gcit.lms.entity.*;

public class BorrowerService {
	
	
	public boolean CheckId(int cardNo) throws SQLException {
		
		Connection conn =  ConnectionUtil.getConnection();
		
		BorrowerDAO borrower = new BorrowerDAO(conn);
		
		
		return borrower.CheckID(cardNo);
		
	}
	
	public List<bookCopies> viewtitle(int branchID) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			
			BookCopiesDAO adao = new BookCopiesDAO(conn);
			
			return adao.readAllTitle(branchID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public List<Book> viewtitle(int branchId,  int cardNo) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			
			BookDAO adao = new BookDAO(conn);
			
			return adao.readAllBook(branchId,cardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	
	public void checkOut(Loans l) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			LoansDAO ldao = new LoansDAO(conn);
			ldao.checkOut(l);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void Return(Loans l) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			LoansDAO ldao = new LoansDAO(conn);
			ldao.Return(l);;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	
	public List<Branch> viewBranch(int cardNo) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		
		try {
			//System.out.println("viewAuthor service");
			BranchDAO bdao = new BranchDAO(conn);
			
			return bdao.readAllBranch2(cardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
}

}
