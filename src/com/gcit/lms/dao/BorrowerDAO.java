package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;

@SuppressWarnings("unchecked")
public class BorrowerDAO extends BaseDAO{

	public BorrowerDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void addBorrower(Borrower borrower) throws SQLException
	{
		save("insert into tbl_borrower (name, address, phone) values (?,?,?)", new Object [] {borrower.getBorrowerName(), borrower.getBorrowerAddress(), borrower.getBorrowerPhone()});
	}
	public Integer addBorrowerWithId(Borrower borrower) throws SQLException
	{
		return saveWithID("insert into tbl_borrower (name, address, phone) values (?,?,?)", new Object []{borrower.getBorrowerName(), borrower.getBorrowerAddress(), borrower.getBorrowerPhone()});
	}
	public void updateBorrower(Borrower borrower) throws SQLException {
		
		save("update tbl_borrower set name = ?, address = ? , phone=? where cardNo = ?",
				new Object[] { borrower.getBorrowerName(), borrower.getBorrowerAddress(),borrower.getBorrowerPhone(), borrower.getCarNo() });
	}

	public void deleteBorrower(Borrower borrower) throws SQLException {
		save("delete from tbl_borrower where cardNo = ?", new Object[] { borrower.getCarNo()});
	}

	public List<Borrower> readAllBorrower() throws SQLException {
		
		return read("select * from tbl_borrower", null);
	}
	public List<Borrower> readAllBorrower(int brId) throws SQLException {
		
		return read("Select distinct * from tbl_borrower, tbl_book_loans where tbl_borrower.cardNo = tbl_book_loans.cardNo and tbl_book_loans.branchId = ? and tbl_book_loans.dateIn is null", new Object[] {brId});
	}

	public Integer getBorrowerCount() throws SQLException {
		return getCount("select count(*) from tbl_borrower", null);
	}
	
	@Override
	public List<Borrower> extractData(ResultSet rs) {
		List<Borrower> borrower = new ArrayList<Borrower>();
		BookDAO bdao = new BookDAO(conn);
		BranchDAO bd= new BranchDAO(conn);
		try {
			while (rs.next()) {
				Borrower b = new Borrower();
				b.setCarNo(rs.getInt("cardNo"));
				b.setBorrowerName(rs.getString("name"));
				b.setBorrowerAddress(rs.getString("address"));
				b.setBorrowerPhone(rs.getString("phone"));
				
				
				borrower.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borrower;
	}

	@Override
	public List<Borrower> extractDataFirstLevel(ResultSet rs) {
		List<Borrower> branch = new ArrayList<Borrower>();
		try {
			while (rs.next()) {
				Borrower b = new Borrower();
				b.setCarNo(rs.getInt("cardNo"));
				b.setBorrowerName(rs.getString("name"));
				b.setBorrowerAddress(rs.getString("address"));
				b.setBorrowerPhone(rs.getString("phone"));
				branch.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branch;
	}
	public Borrower readByID(Integer boID) throws SQLException {
		List<Borrower> borrower = read("select * from tbl_borrower where cardNo = ?", new Object[] {boID});
		if(borrower!=null){
			return borrower.get(0);
		}
		return null;
	}
	
	public boolean CheckID(Integer boID) throws SQLException {
		List<Borrower> borrower = read("select * from tbl_borrower where cardNo = ?", new Object[] {boID});
		//System.out.println(borrower.get(0).getCarNo());
		if(!borrower.isEmpty()){
			return true;
		}
		else {
			return false;
		}
		
	}

}
