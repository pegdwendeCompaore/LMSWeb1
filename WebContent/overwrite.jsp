<%@include file="include.html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%@ page import="com.gcit.lms.entity.*"%>
<%
	AdminService service = new AdminService();
	
	List<Branch> branch = new ArrayList<Branch>();
	
		branch = service.viewBranch();	
	
	
%>
<h2>Hello Admin!</h2>
<h3>Select the borrower branch Below to overwrite is book due date.</h3>

<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="row">
	<div class="col-md-6">
		<table  id="myTable" class="table table-striped">
			<thead>
				<tr>
					<th>Branch ID</th>
					<th>branch Name</th>
					<th>branch Address</th>
					<th>Edit Borrower</th>
					
				</tr>
			</thead>
			<tbody>
				<%
					for (Branch b : branch) {
				%>

				<tr>
					<td><%=b.getBranchId() %></td>
					<td><%=b.getBranchName() %></td>
					<td><%=b.getBranchAddres() %></td>
					
					
					<td>
					
					<button name="Edit" class="btn btn-sm btn-success" 
					onclick="window.location.href='overwrite2.jsp?branchId=<%=b.getBranchId() %>'">Select</button>
				
				
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