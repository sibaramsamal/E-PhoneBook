<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="com.dao.ContactDAO , com.model.Contact" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit-contact page</title>
<link rel="stylesheet" href="Common-Resources/style.css">
<style>
	form{
		text-align: center;
	}
</style>
</head>
<body>
	<%@include file="Common-Resources/nav-bar.jsp" %>
	<%
		if(u == null){
			ss.setAttribute("err-msg", "Please login first!!!");
			response.sendRedirect("user-login.jsp");
		}
	%>
	<div class="container">
		<%
			int id = Integer.parseInt(request.getParameter("id"));
			ContactDAO dao = new ContactDAO();
			Contact c = dao.getContactById(id);
			if(c != null){
		%>
		<form action="edit-contact" method="post">
			<h1>Edit Contact</h1>
			<%
				String msg = (String)ss.getAttribute("err-msg-edtt");
				if(msg != null){
			%>
			<h3 class="txt-danger"><%= msg %></h3>
			<%
				ss.removeAttribute("err-msg-edt");
				}
			%>
			<input type="text" name="c-name" placeholder="Enter contact name" value="<%= c.getCname() %>"><br>
			<input type="email" name="mail" placeholder="Enter mail-ID"value="<%= c.getCmail()%>"><br>
			<input type="text" name="number" placeholder="Enter phone no." value="<%= c.getPhone() %>"><br>
			<input type="text" name="about" placeholder="Additional details" value="<%= c.getAbout() %>"><br>
			<input type="hidden" name="cid" value=<%= c.getCid() %>>
			<input type="submit" class="btn-form" value="Save Changes"> 
			<input type="reset" class="btn-form" value="Cancel">
		</form>
		<%} %>
	</div>
	<%@include file="Common-Resources/footer.jsp"%>
</body>
</html>