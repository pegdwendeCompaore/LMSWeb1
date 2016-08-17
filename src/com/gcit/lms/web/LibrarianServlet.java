package com.gcit.lms.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.lms.entity.Loans;
import com.gcit.lms.entity.bookCopies;
import com.gcit.lms.service.BorrowerService;
import com.gcit.lms.service.LibrarianService;

/**
 * Servlet implementation class LibrarianServlet
 */
@WebServlet({"/LibrarianServlet","/addCopies"})
public class LibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibrarianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		String forwardPage = "";
		
		switch (reqUrl) {
		case "/addCopies":
			
			Integer bookId = Integer.parseInt(request.getParameter("bookId"));
			Integer copies = Integer.parseInt(request.getParameter("copies"));
			System.out.println("yo");
			Integer branchId = Integer.parseInt(request.getParameter("branchId"));
			System.out.println("yo1");
			
		
			bookCopies bc = new bookCopies();
			LibrarianService service = new LibrarianService();
			try {
				
				bc.setBookId(bookId);
				bc.setBranchId(branchId);
				bc.setNoOfCopies(copies);
				service.addCopies(bc);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
				
				forwardPage = "addcopies.jsp";
			
			
		
			break;
		
		default:
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
		rd.forward(request, response);
	}

}
