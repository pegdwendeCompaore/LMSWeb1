package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.entity.bookCopies;

public class LibrarianService {
	
	public List <bookCopies> getCopies( int branchId) throws SQLException 
	{
		Connection conn =  ConnectionUtil.getConnection();
		BookCopiesDAO bDao = new BookCopiesDAO(conn);
		
		
		
		
		try {
			return bDao.getNCopies(branchId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public void addCopies( bookCopies bookCopies) throws SQLException 
	{
		Connection conn =  ConnectionUtil.getConnection();
		BookCopiesDAO bDao = new BookCopiesDAO(conn);
		
		
		
		
		try {
			BookCopiesDAO adao = new BookCopiesDAO(conn);
			adao.addBookCopeies2(bookCopies);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		
	}
	
	

}
