package com.gcit.lms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.gcit.lms.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet({ "/addAuthor", "/viewAuthors", "/addBook", "/editAuthor", "/deleteAuthor", 
	 "/addBorrower" ,"/addBranch", "/addPublisher","/deleteBook",
	"/deleteBorrower" ,"/deleteBranch","/deletePublisher","/editBook",
	"/editBorrower","/editBranch","/editPublisher","/searchAuthor","/overwrite"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		String forwardPage = "viewauthors.jsp";
		AdminService service = new AdminService();
		//System.out.println("get");
		switch (reqUrl) {
		case "/editAuthor":
			Integer authorID = Integer.parseInt(request.getParameter("authorId"));
			Author author = null;
			try {
				author = service.viewAuthorByID(authorID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("author", author);
			forwardPage = "editauthor.jsp";
			break;
		case "/editBook":
			Integer bookId = Integer.parseInt(request.getParameter("BookId"));
			Book book2 = null;
			try {
				book2 = service.viewBookByID(bookId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("book", book2);
			forwardPage = "editbook.jsp";
			break;
		case "/editBranch":
			Integer branchId = Integer.parseInt(request.getParameter("BranchId"));
			Branch branch2 = null;
			try {
				branch2 = service.viewBranchByID(branchId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("branch", branchId);
			forwardPage = "editbranch.jsp";
			break;
		case "/editBorrower":
			Integer boId = Integer.parseInt(request.getParameter("cardNo"));
			Borrower borrower =null;
			try {
				borrower = service.viewBorrowerByID(boId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("cardNo", boId);
			forwardPage = "editborrower.jsp";
			break;
		case "/editPublisher":
			Integer pubId = Integer.parseInt(request.getParameter("pubId"));
			Publisher publisher = null;
			try {
				publisher = service.viewPublisherByID(pubId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("pubId", pubId);
			forwardPage = "editborrower.jsp";
			break;
	
		case "/deleteauthor":
			Integer authorId = Integer.parseInt(request.getParameter("authorId"));
			Author autho = null;
			try {
				autho = service.viewAuthorByID(authorId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("author", autho);
			forwardPage = "deleteAuthor.jsp";
			
		break;
		case "/overwrite":
			Integer brId = Integer.parseInt(request.getParameter("branchId"));
			Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
			Integer bId = Integer.parseInt(request.getParameter("bookId"));
			Loans loans = new Loans();
			loans.setBookId(bId);
			loans.setBranchId(brId);
			loans.setCardNo(cardNo);
			try {
				service.overWrite(loans);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			forwardPage = "admin.jsp";
			
		break;
		case "/deleteAuthor":
			Integer auId = Integer.parseInt(request.getParameter("authorId"));
			System.out.println(auId);
			author = new Author();
			author.setAuthorID(auId);
			try {
				service.deleteAuthor(author);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deleteBook":
			 bookId = Integer.parseInt(request.getParameter("bookId"));
			System.out.println(bookId);
			Book book = new Book();
			book.setBookId(bookId);
			try {
				service.deleteBook(book);
				forwardPage = "viewbook.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deleteBorrower":
			int borrowerId = Integer.parseInt(request.getParameter("cardNo"));
			System.out.println(borrowerId);
			Borrower borrower1 = new Borrower();
			borrower1.setCarNo(borrowerId);
			try {
				service.deleteBorrower(borrower1);
				forwardPage = "viewborrower.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deleteBranch":
			System.out.println("yo");
			 int brchId = Integer.parseInt(request.getParameter("branchId"));
			System.out.println(brchId);
			Branch branch = new Branch();
			branch.setBranchId(brchId);
			try {
				service.deleteBranch(branch);
				forwardPage = "viewbranch.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/deletePublisher":
			 int pubId1 = Integer.parseInt(request.getParameter("pubId"));
			System.out.println(pubId1);
			Publisher pub = new Publisher();
			pub.setPublisherId(pubId1);
			try {
				service.deletePublisher(pub);
				forwardPage = "viewpublisher.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		
		String forwardPage = "viewauthors.jsp";
		AdminService service = new AdminService();
		switch (reqUrl) {
		case "/addAuthor":
			String authorName = request.getParameter("authorName");
			String[]temp =request.getParameterValues("booksId");
			
			List<Book>books2 = new ArrayList<Book>();
			
			
			for(int i=0; i<temp.length; i++)
			{
				Book books = new Book();
			books.setBookId(Integer.parseInt(temp[i]));
			System.out.println(Integer.parseInt(temp[i]));
			
				books2.add(books);
				
			}
			

			
			Author author = new Author();
			author.setAuthorName(authorName);
			author.setBooks(books2);
			
			
			
	
		try {
				service.addAuthor(author);
				for(int i =0; i<author.getBooks().size(); i++)
				{
					System.out.println(author.getBooks().get(i).getBookId());
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			//forwardPage = "viewbook.jsp";
			break;
		case "/editAuthor":
			authorName = request.getParameter("authorName");
			Integer authorID = Integer.parseInt(request.getParameter("authorId"));
			author = new Author();
			if (request.getParameterValues("booksId")!=null)
			{
				String[] temp1 = request.getParameterValues("booksId");
				List<Book>books3 = new ArrayList<Book>();


				for(int i=0; i<temp1.length; i++)
				{
					Book books = new Book();
					books.setBookId(Integer.parseInt(temp1[i]));
					System.out.println(Integer.parseInt(temp1[i]));

					books3.add(books);

				}
				
			author.setBooks(books3);
			}
			
			
			author.setAuthorName(authorName);
			author.setAuthorID(authorID);
			System.out.println("by pass");
			try {
				
				service.editAuthor(author);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/editBook":
			String bookTitle = request.getParameter("title");
			Integer bookID = Integer.parseInt(request.getParameter("bookId"));
			Integer edPubId = Integer.parseInt(request.getParameter("publishers"));
			
			List <Author> edAuthors = new ArrayList<Author>();
			List <Genre> edGenres = new ArrayList<Genre>();
			if(request.getParameterValues("authors")!=null)
			{
				String [] edAuthor = request.getParameterValues("authors");
			for(int i=0; i<edAuthor.length; i++)
			{
			 author = new Author();
			 author.setAuthorID(Integer.parseInt(edAuthor[i]));
			
			
				edAuthors.add(author);
				
			}
			}
			if(request.getParameterValues("genres")!=null)
			{
				String [] edGenre = request.getParameterValues("genres");
			for(int i=0; i<edGenre.length; i++)
			{
			 Genre genre = new Genre();
			 genre.setGenreId(Integer.parseInt(edGenre[i]) );
				edGenres.add(genre);
			}
			}
			
			
			Book book2 = new Book();
			book2.setTitle(bookTitle);
			book2.setBookId(bookID);
			book2.setPubId(edPubId);
			book2.setAuthors(edAuthors);
			book2.setGenres(edGenres);
			try {
				service.editBook(book2);
			
				forwardPage = "viewbook.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/editBranch":
			String brName1 = request.getParameter("name");
			String brAddress1 = request.getParameter("address");
			Integer brId = Integer.parseInt(request.getParameter("branchId"));
			Branch branch4 = new Branch();
			if (request.getParameterValues("booksId")!=null)
			{
				String[] brTemp = request.getParameterValues("booksId");
				List<Book>books4 = new ArrayList<Book>();


				for(int i=0; i<brTemp.length; i++)
				{
					Book books = new Book();
					books.setBookId(Integer.parseInt(brTemp[i]));
					System.out.println(Integer.parseInt(brTemp[i]));

					books4.add(books);

				}
				branch4.setBooks(books4);
		
			}
			
			
			branch4.setBranchName(brName1);
			branch4.setBranchAddres(brAddress1);
			branch4.setBranchId(brId);
			try {
				service.editBranch(branch4);
				forwardPage = "viewbranch.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/editBorrower":
			String boName = request.getParameter("name");
			String boAddress = request.getParameter("address");
			String boPhone = request.getParameter("phone");
			Integer boId = Integer.parseInt(request.getParameter("cardNo"));
			
			Borrower borrower = new Borrower();
			borrower.setBorrowerName(boName);
			borrower.setBorrowerAddress(boAddress);
			borrower.setBorrowerPhone(boPhone);
			borrower.setCarNo(boId);
			try {
				service.editBorrower(borrower);
				forwardPage = "viewborrower.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/editPublisher":
			String puName = request.getParameter("name");
			String puAddress = request.getParameter("address");
			String puPhone = request.getParameter("phone");
			System.out.println(puPhone+" "+puAddress+" "+ puName);
			Integer Id = Integer.parseInt(request.getParameter("pubId"));
			
			Publisher publisher1 = new Publisher();
			publisher1.setPublisherName(puName);
			publisher1.setPublisherAddress(puAddress);
			publisher1.setPublisherPhone(puPhone);
			publisher1.setPublisherId(Id);
			
			try {
				service.editPublisher(publisher1);
				forwardPage = "viewpublisher.jsp";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/addBook":
		
			forwardPage = "viewbook.jsp";
			String title = request.getParameter("bookName");
			String [] authors = request.getParameterValues("authors");
			Integer bPubId= Integer.parseInt(request.getParameter("publishers"));
			String [] genres = request.getParameterValues("genres");
			List <Author> bAuthors = new ArrayList<Author>();
			List <Genre> bGenre = new ArrayList<Genre>();
			
			for(int i=0; i<authors.length; i++)
			{
			 author = new Author();
			 author.setAuthorID(Integer.parseInt(authors[i]));
			
			
				bAuthors.add(author);
				
			}
			 System.out.println("succees");
			for(int i=0; i<genres.length; i++)
			{
			 Genre genre = new Genre();
			 genre.setGenreId(Integer.parseInt(genres[i]) );
				bGenre.add(genre);
			}
			
			Book book = new Book();
			
			book.setTitle(title);
			book.setPubId(bPubId);
			book.setGenres(bGenre);
			book.setAuthors(bAuthors);
			
			try {
	

				 service.addBook(book);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		break;
		case "/addBorrower":
			
			forwardPage = "admin.jsp";
			String bName = request.getParameter("borrowerName");
			String bAddress = request.getParameter("borrowerAddress");
			String bPhone = request.getParameter("borrowerPhone");
			Borrower borrowe = new Borrower();
			borrowe.setBorrowerName(bName);
			borrowe.setBorrowerAddress(bAddress);
			borrowe.setBorrowerPhone(bPhone);
			
			try {
				 
				 service.addBorrower(borrowe);
				 System.out.println("succees");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		break;
		case "/addBranch":
			
			forwardPage = "admin.jsp";
			String brName = request.getParameter("branchName");
			String brAddress = request.getParameter("branchAddress");
			String[] brBook = request.getParameterValues("booksId");
			List <Book> brBooks = new ArrayList<Book>();

			for(int i=0; i<brBook.length; i++)
			{
				Book books = new Book();
				books.setBookId(Integer.parseInt(brBook[i]));
				System.out.println(Integer.parseInt(brBook[i]));

				brBooks.add(books);

			}


			

			Branch branch1 = new Branch();
			branch1.setBranchName(brName);
			branch1.setBranchAddres(brAddress);
			branch1.setBooks(brBooks);

			try {

				service.addBranch(branch1);
				System.out.println("succees");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
	case "/addPublisher":
		
		forwardPage = "admin.jsp";
		String pName = request.getParameter("publisherName");
		String pAddress = request.getParameter("publisherAddress");
		String pPhone = request.getParameter("publisherPhone");
		Publisher publisher = new Publisher();
		publisher.setPublisherName(pName);
		publisher.setPublisherAddress(pAddress);
		publisher.setPublisherPhone(pPhone);
		try {
			 
			 service.addPublisher(publisher);;
			 System.out.println("succees");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	break;
	
		default:
			break;
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}

}
