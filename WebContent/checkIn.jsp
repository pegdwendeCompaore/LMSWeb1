<%@include file="include.html"%>
<%@ page import="java.util.*"%>
<%@ page import="com.gcit.lms.service.*"%>
<%@ page import="com.gcit.lms.entity.*"%>
<%
	
Integer cardNo = Integer.parseInt(request.getParameter("cardNo"));
	BorrowerService service = new BorrowerService();
	
	List<Branch> branch = new ArrayList<Branch>();
		//out.println(cardNo);
		branch = service.viewBranch(cardNo);	
	
	
%>

<style>
.center {
    margin: auto;
    text-align: center;
    width: 60%;
    border: 3px solid #73AD21;
    padding: 10px;
}

</style>

<h3 class="center">Select the Branch you wish to return a book</h3>

<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<div class="center">
<div class="table-responsive">
<table id="myTable" class="display table" width="100%" >
			<thead>
				<tr>
					<th>branch Name</th>
					<th>branch Address</th>
				
					<th>select</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Branch b : branch) {
				%>

				<tr>
					<td><%=b.getBranchName() %></td>
					<td><%=b.getBranchAddres() %></td>
					
				
					
					
					<td>
					
					<button name="Edit" class="btn btn-sm btn-success" data-toggle="modal" data-target="#myModal"
					 href="returnbook.jsp?branchId=<%=b.getBranchId()%>&cardNo=<%=cardNo %>" >Select</button>
					
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

<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">

    </div>
  </div>
</div>