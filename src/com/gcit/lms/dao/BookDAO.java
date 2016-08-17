package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;

@SuppressWarnings("unchecked")
public class BookDAO extends BaseDAO{

	public BookDAO(Connection conn) {
		super(conn);
	}

	public void addBook(Book book) throws SQLException{
		int bId = addBookWithId(book);

		for (int i=0; i<book.getAuthors().size();i++)
		{
			save("insert into tbl_book_authors (bookId, authorId) values (?, ?)", new Object[] {bId,book.getAuthors().get(i).getAuthorID()});
		}
		for (int i=0; i<book.getGenres().size();i++)
		{
			save("insert into tbl_book_genres (genre_Id, bookId) values (?, ?)", new Object[] { book.getGenres().get(i).getGenreId(),bId});
		}

	}

	public void updateBook(Book book) throws SQLException{


		save("update tbl_book set title = ?, pubId = ? where bookId = ?", new Object[] {book.getTitle(),book.getPubId(), book.getBookId()});
		if(book.getGenres()!=null)
		{
			save("delete from tbl_book_genres where bookId = ?", new Object[] {book.getBookId()});
			for (int i=0; i<book.getGenres().size(); i++)
			{

				save("insert into tbl_book_genres (genre_Id, bookId) values (?,?)", new Object[] {book.getGenres().get(i).getGenreId(), book.getBookId()});
			}
		}

		if(book.getAuthors()!=null)
		{
			save("delete from tbl_book_authors where bookId = ?", new Object[] {book.getBookId()});
			for (int i=0; i<book.getAuthors().size(); i++)
			{

				save("insert into tbl_book_authors (bookId, authorId) values (?,?)", new Object[] {book.getBookId(), book.getAuthors().get(i).getAuthorID()});
			}
		}


	}

	public void deleteBook(Book book) throws SQLException{
		save("delete from tbl_book where bookId = ?", new Object[] {book.getBookId()});
	}
	public Integer addBookWithId(Book book) throws SQLException{
		return saveWithID("insert into tbl_book (title, pubId) values (?, ?)", new Object[] {book.getTitle(), book.getPubId()});
	}

	//	public List<Book> readAllBook(int pageNo) throws SQLException{
	//		setPageNo(pageNo);
	//		return read("select * from tbl_book", null);
	//
	//	}
	//	public List<A> readAllAuthors(int pageNo) throws SQLException {
	//		setPageNo(pageNo);
	//		return read("select * from tbl_author", null);
	//	}

	@Override
	public List<Book> extractData(ResultSet rs){
		AuthorDAO adao = new AuthorDAO(conn);
		GenreDAO  gDao = new GenreDAO(conn);
		PublisherDAO  pDao = new PublisherDAO(conn);
		List<Book> books = new ArrayList<Book>();
		try {
			while(rs.next()){
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setTitle(rs.getString("title"));
				b.setPubId(rs.getInt("pubId"));
				b.setAuthors(adao.readFirstLevel(
						"select * from tbl_author where authorId IN (select authorId from tbl_book_authors where bookId = ?)",
						new Object[] { b.getBookId()}));
				b.setGenres(gDao.readFirstLevel(
						"select * from tbl_genre where genre_Id IN (select genre_Id from tbl_book_genres where bookId = ?)",
						new Object[] { b.getBookId()}));
				b.setPublishers(pDao.readFirstLevel(
						"select * from tbl_publisher where publisherId  = ?",
						new Object[] { b.getPubId()}));
				books.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> extractDataFirstLevel(ResultSet rs) {
		List<Book> books = new ArrayList<Book>();
		try {
			while(rs.next()){
				Book b = new Book();
				b.setBookId(rs.getInt("bookId"));
				b.setTitle(rs.getString("title"));
				b.setPubId(rs.getInt("pubId"));
				//b.setDueDate(rs.getString("dueDate"));
				books.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public Integer getBookCount() throws SQLException {
		return getCount("select count(*) from tbl_book", null);
	}
	public List<Book> readAllBook() throws SQLException {

		return read("select * from tbl_book", null);
	}


	public List<Book> readAllBook(int branchId,int cardNo) throws SQLException {

		return readFirstLevel("select * from tbl_book join tbl_book_loans on tbl_book.bookId = tbl_book_loans.bookId and tbl_book_loans.branchId = ? and tbl_book_loans.cardNo = ?  and tbl_book_loans.dateIn is null", new Object[]{branchId,cardNo});
	}
	public Book readByID(Integer bookID) throws SQLException {
		List<Book> books = read("select * from tbl_book where bookId = ?", new Object[] {bookID});
		if(books!=null){
			return books.get(0);
		}
		return null;
	}
}
