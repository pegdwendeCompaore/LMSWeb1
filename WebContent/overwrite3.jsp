<%@page import="com.gcit.lms.service.BorrowerService"%>
<%@include file="include.html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%@ page import="com.gcit.lms.entity.*"%>
<%
Integer brId = Integer.parseInt(request.getParameter("branchId"));
Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));

	BorrowerService service = new BorrowerService();
	List<Book> books = new ArrayList<Book>();
		books = service.viewtitle(brId, cardNo);	
%>



<h2>Hello Admin!</h2>
<h3>Below are a list of Book to choose from.</h3>

<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="table-responsive">
	<div class="col-md-6">
		<table id="myTable" class="table table-striped" >
			<thead>
				<tr>
					<th>Book ID</th>
					<th>Book Title</th>
					<th>Publisher Id</th>
					<th>Due Date</th>
					<th>Edit Author</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Book b : books) {
				%>

				<tr>
					<td><%=b.getBookId() %></td>
					<td><%=b.getTitle() %></td>
					<td><%=b.getPubId() %></td>
					<td><%=b.getDueDate() %></td>
					
					<td>
					
					<button name="Edit" class="btn btn-sm btn-success" onclick="javascript:location.href='overwrite?bookId=<%=b.getBookId() %>&branchId=<%=brId %>&cardNo=<%=cardNo %>'">
						Select</button>
							
				
					</td>
					
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
<script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>
		
	</div>
</div>

<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">

    </div>
  </div>
</div>