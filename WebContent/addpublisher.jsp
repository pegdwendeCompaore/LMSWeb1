<%@include file="admin.html" %>
<style>
.center {
    margin: auto;
    text-align: center;
    width: 60%;
    border: 3px solid #73AD21;
    padding: 10px;
}
</style>


	
	<h3 class="center">Enter Publisher Details</h3>
	<form action="addPublisher" method="post">
		<div class="center">
		Enter Publisher Name: <input type="text" name="publisherName">
		<br/>
		Enter Publisher Address: <input type="text" name="publisherAddress">
		<br/>
		Enter Publisher Phone: <input type="text" name="publisherPhone">
		<br/>
		<button type="submit">Add publisher!</button>
		</div>
	</form>