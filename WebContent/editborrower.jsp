<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%
	Integer boId = Integer.parseInt(request.getParameter("cardNo"));
	Borrower borrower = null;
	AdminService service = new AdminService();
	borrower = service.viewBorrowerByID(boId);
%>
<div>
	<h2>Hello Admin!</h2>
	<h3>Enter Borrower Details to Edit</h3>
	<form action="editBorrower" method="post">
		Enter Borrower Name: <input type="text" name="name"
			value="<%=borrower.getBorrowerName()  %>"><br /> 
		Enter Borrower Address: <input type="text" name="address"
			value="<%=borrower.getBorrowerAddress() %>"><br /> 	
		Enter Borrower Phone: <input type="text" name="phone"
			value="<%=borrower.getBorrowerPhone() %>"><br /> 
			<input type="hidden" name="cardNo" value="<%=borrower.getCarNo() %>">
		<button type="submit">Edit Author!</button>
	</form>
</div>