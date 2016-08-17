package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.BookAuthor;
import com.gcit.lms.entity.bookCopies;

public class BookCopiesDAO extends BaseDAO {

	public BookCopiesDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	
public void addBookCopeies(bookCopies bc) throws SQLException {
		
		save("insert into tbl_book_copies (bookId, branchId, noOfCopies) values (?,?,?) ", new Object[] {  bc.getBookId(), bc.getBranchId(), bc.getNoOfCopies() });
	}

public void addBookCopeies2(bookCopies bc) throws SQLException {
	
	save("update tbl_book_copies set noOfCopies = ? where bookId = ? and branchId = ? ", new Object[] { bc.getNoOfCopies(), bc.getBookId(), bc.getBranchId() });
}


public List<bookCopies> readAllTitle(int branchID) throws SQLException {
	
	return read1("select distinct * from tbl_book join tbl_book_copies on tbl_book_copies.bookId = tbl_book.bookId where tbl_book_copies.noOfCopies >'0' and tbl_book_copies.branchId = ? ", new Object[] {branchID});
}

public List<bookCopies> getNCopies(int branchId) throws SQLException {
	
	return readFirstLevel("select tbl_book_copies.noOfCopies, tbl_book.title, tbl_book.bookId from tbl_book_copies, tbl_book where tbl_book_copies.branchId = ? and tbl_book_copies.bookId = tbl_book.bookId", new Object[] {branchId});
}
@Override
public List<bookCopies> extractData(ResultSet rs) {
	
	List<bookCopies> bc = new ArrayList<bookCopies>();
	
	try {
		while (rs.next()) {
			bookCopies b = new bookCopies();
			b.setTitle(rs.getString("title"));
			b.setBookId(rs.getInt("bookId"));
			bc.add(b);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bc;
}
	

	@Override
	public  List<bookCopies> extractDataFirstLevel(ResultSet rs) {
		List<bookCopies> bc = new ArrayList<bookCopies>();
		
		try {
			while (rs.next()) {
				bookCopies b = new bookCopies();
				b.setBookId(rs.getInt("bookId")); 
				b.setNoOfCopies(rs.getInt("noOfCopies"));
				b.setTitle(rs.getString("title"));
				bc.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bc;
	}

}
