<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="com.gcit.lms.service.AdminService"%>
<%@ page import="java.util.*"%>
<%
	Integer authorID = Integer.parseInt(request.getParameter("authorId"));
	Author author = null;
	AdminService service = new AdminService();
	author = service.viewAuthorByID(authorID);
	List<Book> book = new ArrayList<Book>();
	
	book = service.viewBook();	
%>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
  <link href="./template_files/css/highlight.css" rel="stylesheet">
  <link href="./template_files/css/base.css" rel="stylesheet">
  <link href="./template_files/css/custom.css" rel="stylesheet">
  <link href="./template_files/css/bootstrap-select.min.css" rel="stylesheet">
<div>
	<h2>Hello Admin!</h2>
	<h3>Enter Author Details to Edit</h3>

	<form action="editAuthor" method="post">
		Enter Author Name: <input type="text" name="authorName"
			value="<%=author.getAuthorName()%>"><br /> <br /> <br /> <input
			type="hidden" name="authorId" value="<%=author.getAuthorID()%>"><br />   
			
			Select book published <br/>

	<h2 id="multiple-select-boxes"></h2>
  	<select class="selectpicker" name="booksId" data-live-search="true" multiple>

	<%
					for (Book a : book) {
				%>


	<option value="<%=a.getBookId() %>" ><%=a.getTitle()%></option>
	
	<%
					}
				%>


</select>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="./template_files/js/highlight.pack.js"></script>
<script src="./template_files/js/base.js"></script>
<script src="./template_files/js/bootstrap-select.min.js"></script>

<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-35848102-1']);
  _gaq.push(['_trackPageview']);

  (function () {
    var ga = document.createElement('script');
    ga.type = 'text/javascript';
    ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(ga, s);
  })();
</script>
<br/> <br />
			
			
		<button type="submit">Edit Author!</button>
	</form>
</div>