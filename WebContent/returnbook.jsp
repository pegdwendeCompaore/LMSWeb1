
<%@ page import="java.util.*"%>
<%@ page import="com.gcit.lms.service.*"%>
<%@ page import="com.gcit.lms.entity.*"%>
<%

int brId = Integer.parseInt(request.getParameter("branchId"));
Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));

	BorrowerService servic = new BorrowerService();

	List<Book> bc = new ArrayList<Book>();
		bc = servic.viewtitle(brId, cardNo);
		
	
%>

<div class="modal-header ">
		
	Select Book title 
</div>
<div class="modal-body">	

<form action="returned" method="post">
<select class="selectpicker " name="bookId">

	<%
					for (Book b : bc) {
				%>


	<option value="<%=b.getBookId() %>" ><%=b.getTitle() %></option>
	
	<%
					}
				%>


</select>
<input
			type="hidden" name="branchId" value="<%=brId%>">
			<input
			type="hidden" name="cardNo" value="<%=cardNo%>">
	
<br/> <br/>
<button type="submit">Return!</button>
</form>

</div>