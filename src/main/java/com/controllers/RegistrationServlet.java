package com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.model.User;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String name = req.getParameter("user-name");
		String email = req.getParameter("user-id");
		String password = req.getParameter("pass");
		
		User u = new User(name,email,password);
		UserDAO dao = new UserDAO();
		boolean result = false;
		try {
			result = dao.registerUser(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result != false) {
			HttpSession ses = req.getSession();
			ses.setAttribute("suc-msg", "Resistration Successful... ");
		}
		else {
			HttpSession ses = req.getSession();
			ses.setAttribute("fail-msg", "Something gone wrong !!! ");
			ses.removeAttribute("err-msg");
		}
		res.sendRedirect("user-register.jsp");
	}
}
