<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add-new-contact page</title>
<link rel="stylesheet" href="Common-Resources/style.css">
<style type="text/css">
	.container{
		justify-content: space-between;
	}
	form{
		height: 350px;
	}
	.right-section img {
		width: 800px;
		margin-right: 70px;
	}
</style>
</head>
<body>
	<%@include file="Common-Resources/nav-bar.jsp"%>
	<%
		if(u == null){
			ss.setAttribute("err-msg", "Please login first!!!");
			response.sendRedirect("user-login.jsp");
		}
	%>
	<div class="container">
	<%
	if (u != null) {
		%>
		<div class="left-section">
			<form action="add-contact" method="post">
				<h1>Add new Contact</h1>
				<%
					String successMsg = (String)ss.getAttribute("suc-msg-cnt");
					String errorMsg = (String)ss.getAttribute("err-msg-cnt");
					if(successMsg != null){
				%>
				<h3 class="txt-green"><%= successMsg %></h3>
				<%
					ss.removeAttribute("suc-msg-cnt");
					}
					if(errorMsg != null){
				%>
				<h3 class="txt-danger"><%= errorMsg %></h3>
				<%
					ss.removeAttribute("err-msg-cnt");
					}
				%>
				<input type="text" name="c-name" placeholder="Enter contact name" required="true"><br>
				<input type="email" name="mail" placeholder="Enter mail-ID" required="true"><br>
				<input type="text" name="number" placeholder="Enter phone no." required="true"><br>
				<input type="text" name="about" placeholder="Additional details" required="true"><br>
				<input type="hidden" name="sid" value=<%= u.getUid() %>>
				<input type="submit" class="btn-form" value="Save Contact"> 
				<input type="reset" class="btn-form" value="Cancel">
			</form>
		</div>
		<%} %>
		<div class="right-section">
			<image src="images/add-contact.svg">
		</div>
	</div>
	<%@include file="Common-Resources/footer.jsp"%>
</body>
</html>