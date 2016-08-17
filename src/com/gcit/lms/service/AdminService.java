package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookAuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookGenreDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.LoansDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookAuthor;
import com.gcit.lms.entity.BookGenre;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Loans;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.entity.bookCopies;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

public class AdminService {
	
	public void addAuthor(Author author) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			adao.addAuthor(author);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void addBorrower(Borrower borrower) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			bdao.addBorrower(borrower);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public int addAuthorWithId(Author author) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		int aId=0 ;
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			aId = adao.addAuthorWithID(author);
			conn.commit();
		
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
		return aId;
	}
	public void addBranch(Branch branch) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			bdao.addBranch(branch);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void addBook(Book book) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			 bdao.addBook(book);
			conn.commit();
		
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
		
	}
	public void addBookAthor(BookAuthor ba) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookAuthorDAO adao = new BookAuthorDAO(conn);
			adao.addBookAuthor(ba);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void addBookCopies(bookCopies bc) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookCopiesDAO adao = new BookCopiesDAO(conn);
			adao.addBookCopeies(bc);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void addBookGenre(BookGenre bg) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookGenreDAO bgdao = new BookGenreDAO(conn);
			bgdao.addBookGenre(bg);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void addPublisher(Publisher pub) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			PublisherDAO pdao = new PublisherDAO(conn);
			pdao.addPublisher(pub);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	
	public void deleteAuthor(Author author) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			adao.deleteAuthor(author);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void deleteBook(Book book) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			bdao.deleteBook(book);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void deleteBorrower(Borrower borrower) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			bdao.deleteBorrower(borrower);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void deleteBranch(Branch branch) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			bdao.deleteBranch(branch);;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}	
	public void deletePublisher(Publisher publisher) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			PublisherDAO bdao = new PublisherDAO(conn);
			bdao.deletePublisher(publisher);;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	
	public List<Author> viewAuthors() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			//System.out.println("viewAuthor service");
			AuthorDAO adao = new AuthorDAO(conn);
			
			return adao.readAllAuthors();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public List<Branch> viewBranch() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		
		try {
			//System.out.println("viewAuthor service");
			BranchDAO bdao = new BranchDAO(conn);
			
			return bdao.readAllBranch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public List<Publisher> viewPublisher() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			//System.out.println("viewAuthor service");
			PublisherDAO pdao = new PublisherDAO(conn);
			
			return pdao.readAllPublishers();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public List<Genre> viewGenre() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			//System.out.println("viewAuthor service");
			GenreDAO gdao = new GenreDAO(conn);
			
			return gdao.readAllGenre();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public List<Borrower> viewBorrower() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			//System.out.println("viewAuthor service");
			BorrowerDAO bdao = new BorrowerDAO(conn);
			
			return bdao.readAllBorrower();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public List<Borrower> viewBorrower(int brId) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			
			return bdao.readAllBorrower(brId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public List<Branch> viewBranch2() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			//System.out.println("viewAuthor service");
			BranchDAO bdao = new BranchDAO(conn);
			
			return bdao.readAllBranch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public List<Publisher> viewPublisher2() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			//System.out.println("viewAuthor service");
			PublisherDAO bdao = new PublisherDAO(conn);
			
			return bdao.readAllPublishers();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	

	
	public Author viewAuthorByID(Integer authorID) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			
			return adao.readByID(authorID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public Book viewBookByID(Integer BookID) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			
			return bdao.readByID(BookID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public Borrower viewBorrowerByID(Integer cardNo) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BorrowerDAO bdao = new BorrowerDAO(conn);
			
			return bdao.readByID(cardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public Branch viewBranchByID(Integer branchId) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BranchDAO bdao = new BranchDAO(conn);
			
			return bdao.readByID(branchId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	public Publisher viewPublisherByID(Integer pubId) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			PublisherDAO bdao = new PublisherDAO(conn);
			
			return bdao.readByID(pubId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	

	public void editAuthor(Author author) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			adao.updateAuthor(author);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void editBook(Book book) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookDAO adao = new BookDAO(conn);
			adao.updateBook(book);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void editBorrower(Borrower borrower) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BorrowerDAO adao = new BorrowerDAO(conn);
			adao.updateBorrower(borrower);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	public void editBranch(Branch branch) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BranchDAO adao = new BranchDAO(conn);
			adao.updateBranch(branch);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}		
	public void editPublisher(Publisher publisher) throws SQLException {
		Connection conn =  ConnectionUtil.getConnection();
		try {
			PublisherDAO adao = new PublisherDAO(conn);
			adao.updatePublisher(publisher);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}
	
	
	public Integer getAuthorCountsearch(String q) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.getAuthorCount2(q);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
			
		}
		return null;
	}
	public Integer getBookCount() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BookDAO adao = new BookDAO(conn);
			return adao.getBookCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
			
		}
		return null;
	}
	public Integer getBorrowerCount() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BorrowerDAO adao = new BorrowerDAO(conn);
			return adao.getBorrowerCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
			
		}
		return null;
	}
	public Integer getBranchCount() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			BranchDAO adao = new BranchDAO(conn);
			return adao.getBranchCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
			
		}
		return null;
	}
	public Integer getPublisherCount() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			PublisherDAO adao = new PublisherDAO(conn);
			return adao.getPublisherCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
			
		}
		return null;
	}
	public List<Book> viewBook() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		System.out.println("viewBook service");
		try {
			BookDAO ada = new BookDAO(conn);
			
			return ada.readAllBook();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return null;
	}
	
	public Integer getAuthorCount() throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.getAuthorCount();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			conn.close();
			
		}
		return null;
	}
	
	public void overWrite(Loans l) throws SQLException{
		Connection conn =  ConnectionUtil.getConnection();
		try {
			LoansDAO ldao = new LoansDAO(conn);
			ldao.overWrite(l);
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally{
			conn.close();
		}
	}

}
