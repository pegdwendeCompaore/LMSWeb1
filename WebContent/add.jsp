<%@include file="include.html"%>
<%
Integer bId = Integer.parseInt(request.getParameter("branchId"));
Integer bookId = Integer.parseInt(request.getParameter("bookId"));
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

<h1 class="center">Enter  Number of copies for branch selected :</h1><br/>
 <div class="center">
<form action="addCopies" method="post">

<input type="number" name="copies"><br /> <br />

<input type="hidden" name="bookId" value="<%=bookId %>"><br /> <br />
<input type="hidden" name="branchId" value="<%=bId %>">

<button type="submit">Add Copies!</button>
</form>
</div>

