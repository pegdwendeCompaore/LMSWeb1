package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Branch;
@SuppressWarnings("unchecked")
public class BranchDAO extends BaseDAO{

	public BranchDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void addBranch(Branch branch) throws SQLException
		{	
			int brId = addBranchWithId(branch);
			for (int i=0; i<branch.getBooks().size(); i++)
			{
			save("insert into tbl_book_copies (bookId, branchId, noOfCopies) values (?,?,?)",new Object[]{branch.getBooks().get(i).getBookId(), brId, 1});	
			}
			
		}
		public Integer addBranchWithId(Branch branch) throws SQLException
		{
			return saveWithID("insert into tbl_library_branch (branchName, branchAddress) values (?,?)", new Object []{branch.getBranchName(), branch.getBranchAddres()});
		}
		public void updateBranch(Branch branch) throws SQLException {
			
			save("update tbl_library_branch set branchName = ?, branchAddress = ? where branchId = ?",
					new Object[] { branch.getBranchName(), branch.getBranchAddres(), branch.getBranchId() });
			if(branch.getBooks()!=null)
			{save("delete from tbl_book_copies where branchId = ?",new Object[] { branch.getBranchId() });
				for(int i=0; i<branch.getBooks().size(); i++)
				{
					save("insert tbl_book_copies (bookId, branchId,noOfCopies) values (?,?,?)",
							new Object[] { branch.getBooks().get(i).getBookId(), branch.getBranchId(), 1 });
				}
			}
		}
	
		public void deleteBranch(Branch branch) throws SQLException {
			save("delete from tbl_library_branch where branchId = ? ", new Object[] { branch.getBranchId()});
		}

		
//		public List<Branch> readAllBranch1() throws SQLException {
//			
//			return read1("select * from tbl_library_branch", null);
//		}
		public List<Branch> readAllBranch2(int cardNo) throws SQLException {
			
			return read1("Select distinct tbl_library_branch.branchId, tbl_library_branch.branchName, tbl_library_branch.branchAddress from tbl_library_branch join tbl_book_loans where tbl_library_branch.branchId = tbl_book_loans.branchId and tbl_book_loans.cardNo = ? and dateIn is null ", new Object[] {cardNo});
		}
		

		
	
		public List<Branch> readAllBranch() throws SQLException {
			
			return read("select * from tbl_library_branch", null);
		}
	
		public Integer getBranchCount() throws SQLException {
			return getCount("select count(*) from tbl_library_branch", null);
		}
		
		@Override
		public List<Branch> extractData(ResultSet rs) {
			List<Branch> branch = new ArrayList<Branch>();
			BookDAO bdao = new BookDAO(conn);
			try {
				while (rs.next()) {
					Branch b = new Branch();
					b.setBranchId(rs.getInt("branchId"));
					b.setBranchName(rs.getString("branchName"));
					b.setBranchAddres(rs.getString("branchAddress"));
					b.setBooks(bdao.readFirstLevel(
							"select * from tbl_book where bookId IN (select bookId from tbl_book_copies where branchId = ? and noOfCopies >0)",
							new Object[] {b.getBranchId()}));
					branch.add(b);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return branch;
		}
	
		@Override
		public List<Branch> extractDataFirstLevel(ResultSet rs) {
			List<Branch> branch = new ArrayList<Branch>();
			try {
				while (rs.next()) {
					Branch b = new Branch();
					b.setBranchId(rs.getInt("branchId"));
					b.setBranchName(rs.getString("branchName"));
					b.setBranchAddres(rs.getString("branchAddress"));
					branch.add(b);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return branch;
		}
		public Branch readByID(Integer branchID) throws SQLException {
			List<Branch> branch = read("select * from tbl_library_branch where branchId = ?", new Object[] {branchID});
			if(branch!=null){
				return branch.get(0);
			}
			return null;
		}

}
