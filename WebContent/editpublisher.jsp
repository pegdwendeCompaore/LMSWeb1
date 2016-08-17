<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%
	Integer pubId = Integer.parseInt(request.getParameter("pubId"));
out.print(pubId);
	Publisher publisher = null;
	AdminService service = new AdminService();
	publisher = service.viewPublisherByID(pubId);
%>
<div>
	<h2>Hello Admin!</h2>
	<h3>Enter publisher Details to Edit</h3>
	<form action="editPublisher" method="post">
		Enter publisher Name: <input type="text" name="name"
			value="<%=publisher.getPublisherName()  %>"><br /> 
		Enter publisher Address: <input type="text" name="address"
			value="<%=publisher.getPublisherAddress()  %>"><br /> 	
		Enter publisher Phone: <input type="text" name="phone"
			value="<%=publisher.getPublisherPhone() %>"><br /> 	
			<input type="hidden" name="pubId" value="<%=publisher.getPublisherId() %>">
		<button type="submit">Edit publisher!</button>
	</form>
</div>