package com.gcit.lms.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Loans;
import com.gcit.lms.service.AdminService;
import com.gcit.lms.service.BorrowerService;

/**
 * Servlet implementation class BorrowerServlet
 */
@WebServlet({"/checkId","/checked","/returned"})
public class BorrowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    int card;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		String forwardPage = "";
		BorrowerService service = new BorrowerService();
		
		switch (reqUrl) {
		
		case "/returned":
			
			Integer bId = Integer.parseInt(request.getParameter("bookId"));
			
			Integer brId = Integer.parseInt(request.getParameter("branchId"));
			Integer cardNo= Integer.parseInt(request.getParameter("cardNo"));
			
			Loans l = new Loans();
			
			l.setBookId(bId);
			l.setBranchId(brId);
			l.setCardNo(cardNo);
			try {
				service.Return(l);
				System.out.print("yo");
				forwardPage = "borrowerMenu.jsp";
			} catch (SQLException e) {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		String forwardPage = "";
		BorrowerService service = new BorrowerService();
		
		switch (reqUrl) {
		case "/checkId":
			
			Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
			
			boolean logIn=false;
			try {
				logIn = service.CheckId(cardNo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(logIn ==true)
			{
				card = cardNo;
				forwardPage = "borrowerMenu.jsp";
				request.setAttribute("cardNo", cardNo);
			}
			else {
				forwardPage = "borrower.jsp";
			}
			
		
			break;
		case "/checked":
			Integer bId = Integer.parseInt(request.getParameter("bookId"));
			Integer brId = Integer.parseInt(request.getParameter("branchId"));
			
			Loans loans = new Loans();
			loans.setBookId(bId);
			loans.setBranchId(brId);
			loans.setCardNo(card);
			try {
				service.checkOut(loans);
				request.setAttribute("cardNo", card);
				forwardPage = "borrowerMenu.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/returned":
			
			 bId = Integer.parseInt(request.getParameter("bookId"));
			 System.out.print("yo");
			 brId = Integer.parseInt(request.getParameter("branchId"));
			 cardNo= Integer.parseInt(request.getParameter("cardNo"));
			
			Loans l = new Loans();
			l.setBookId(bId);
			l.setBranchId(brId);
			l.setCardNo(cardNo);
			try {
				service.Return(l);
				
				forwardPage = "borrowerMenu.jsp";
			} catch (SQLException e) {
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
