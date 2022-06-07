<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.ContactDAO , com.model.Contact , java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view-contacts page</title>
<link rel="stylesheet" href="Common-Resources/style.css">
<style type="text/css">
	body{
		display: flex;
		flex-direction: column;
	}
	.container{
		box-sizing: content-box;
		display: flex;
		justify-content: flex-start;
		flex-direction: row;
		flex-wrap: wrap;
		margin-top: 0px;
		}
	.card{
		position: relative;
		padding: 10px;
		margin-left: 50px;
		margin-top: 50px;
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
		if (u != null) {
			ContactDAO dao = new ContactDAO();
			List<Contact> l = dao.getContacts(u.getUid());
	%>
	<div class="container">
	<%
		String successMsg = (String)ss.getAttribute("suc-msg-edt");
		if(successMsg != null){
			%>
				<h1 class="txt-green"><%= successMsg %></h1>
			<%
			ss.removeAttribute("suc-msg-edt");
		}
		for(Contact c : l){
		%>
			<div class="card">
			<div>
				<h3>Name:<%= c.getCname() %></h3><br>
				Phone No.:<%= c.getPhone() %>
				Email ID: <%= c.getCmail() %>
				Info: <%= c.getAbout() %>
			</div>
			<div class=btns>
				<a class="btn-crd-green" href="edit-contact.jsp?id=<%= c.getCid() %>">Edit</a>
				<a class="btn-crd-red" href="delete?id=<%= c.getCid() %>">Delete</a>
			</div>
			</div>
		<%} %>
	</div>
	<%
		}
	%>
</body>
</html>