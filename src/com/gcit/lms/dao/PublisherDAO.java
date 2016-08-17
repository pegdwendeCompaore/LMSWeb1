package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Publisher;


@SuppressWarnings("unchecked")
public class PublisherDAO extends BaseDAO{

	public PublisherDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	
	public void addPublisher(Publisher publisher) throws SQLException {
		save("insert into tbl_publisher (publisherName) values (?)", new Object[] { publisher.getPublisherName()});
	}
	
	public Integer addPublisherWithID(Publisher publisher) throws SQLException {
		return saveWithID("insert into tbl_publisher (publisherName) values (?)", new Object[] { publisher.getPublisherName() });
	}
	
	

	public void updatePublisher(Publisher publisher) throws SQLException {
		save("update tbl_publisher set publisherName = ?, publisherAddress = ?,publisherPhone=?  where publisherId = ?",
				new Object[] { publisher.getPublisherName(), publisher.getPublisherAddress(), publisher.getPublisherPhone(), publisher.getPublisherId() });
	}

	public void deletePublisher(Publisher publisher) throws SQLException {
		save("delete from tbl_publisher where publisherId = ?", new Object[] { publisher.getPublisherId() });
	}

	
	public List<Publisher> readAllPublishers() throws SQLException {
		
		return read("select * from tbl_publisher", null);
	}
	
	public Integer getPublisherCount() throws SQLException {
		return getCount("select count(*) from tbl_publisher", null);
	}
	
	@Override
	public List<Publisher> extractData(ResultSet rs) {
		List<Publisher> publishers = new ArrayList<Publisher>();
		BookDAO bdao = new BookDAO(conn);
		try {
			while (rs.next()) {
				Publisher p = new Publisher();
				p.setPublisherId(rs.getInt("publisherId"));
				
				p.setPublisherName(rs.getString("publisherName"));
				p.setPublisherAddress(rs.getString("publisherAddress"));
				p.setPublisherPhone(rs.getString("publisherPhone"));
				p.setBook(bdao.readFirstLevel(
						"select * from tbl_book where pubId =?",
						new Object[] {p.getPublisherId()}));
				publishers.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publishers;
	}

	@Override
	public List<Publisher> extractDataFirstLevel(ResultSet rs) {
		List<Publisher>publisher = new ArrayList<Publisher>();
		try {
			while (rs.next()) {
				Publisher p = new Publisher();
				p.setPublisherId(rs.getInt("publisherId"));
				p.setPublisherName(rs.getString("publisherName"));
				publisher.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publisher;
	}

	public Publisher readByID(Integer pubID) throws SQLException {
		List<Publisher> publishers = read("select * from tbl_publisher where publisherId = ?", new Object[] {pubID});
		if(publishers!=null){
			return publishers.get(0);
		}
		return null;
	}

}
