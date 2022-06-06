package com.controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String mailId = req.getParameter("user-id");
		String password = req.getParameter("pass");
		UserDAO dao = new UserDAO();
		User user = dao.loginUser(mailId, password);
		if(user != null) {
			HttpSession ss = req.getSession();
			ss.setAttribute("user", user);
			res.sendRedirect("user-dash-board.jsp");
		}
		else {
			HttpSession ss = req.getSession();
			ss.setAttribute("err-msg", "Invalid credentials!!!");
			res.sendRedirect("user-login.jsp");
		}
	}
}
