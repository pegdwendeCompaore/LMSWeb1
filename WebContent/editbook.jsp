<%@ page import="com.gcit.lms.entity.*"%>
<%@ page import="com.gcit.lms.service.*"%>
<%@ page import="java.util.*"%>
<%
	Integer bookId = Integer.parseInt(request.getParameter("bookId"));
	Book book = null;
	AdminService service = new AdminService();
	book = service.viewBookByID(bookId);
%>

<%

	
	List<Branch> branch = new ArrayList<Branch>();
		branch = service.viewBranch();	
	
	
%>
<%

	List<Publisher> publisher = new ArrayList<Publisher>();
		publisher = service.viewPublisher();	
	
	
%>
<%
	List<Genre> genre = new ArrayList<Genre>();
		genre = service.viewGenre()	;
%>

<%
	List<Author> authors = new ArrayList<Author>();
		authors = service.viewAuthors()	;
%>

	<h2>Hello Admin!</h2>
	<h3>Enter Book Details to Edit</h3>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
<link href="./template_files/css/highlight.css" rel="stylesheet">
<link href="./template_files/css/base.css" rel="stylesheet">
<link href="./template_files/css/custom.css" rel="stylesheet">
<link href="./template_files/css/bootstrap-select.min.css" rel="stylesheet">
	<form action="editBook" method="post">
<div>
		Enter Book title: <input type="text" name="title"
			value="<%=book.getTitle()%>"><br /> <input type="hidden"
			name="bookId" value="<%=book.getBookId()%>"> <br/><br/>
			
			Select Authors

		<select class="selectpicker" name="authors" data-live-search="true"
			multiple>

			<%
				for (Author au : authors) {
			%>


			<option value="<%=au.getAuthorID()%>"><%=au.getAuthorName()%></option>

			<%
				}
			%>
		</select>
</div>

<br />
<br />
<div>
	Select publisher <select class="selectpicker" name="publishers"
		data-live-search="true">

		<%
			for (Publisher a : publisher) {
		%>


		<option value="<%=a.getPublisherId()%>"><%=a.getPublisherName()%></option>

		<%
			}
		%>
	</select>



</div>
<br />
<br />
<div>
	Select Book Genre <select class="selectpicker" name="genres"
		data-live-search="true" multiple>

		<%
			for (Genre a : genre) {
		%>


		<option value="<%=a.getGenreId()%>"><%=a.getGenreName()%></option>

		<%
			}
		%>
	</select>
</div>
<button type="submit">Edit Author!</button>
</form>
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

