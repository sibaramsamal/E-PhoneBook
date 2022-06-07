package com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ContactDAO;
import com.model.Contact;

@WebServlet("/add-contact")
public class AddContactServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String contactName = req.getParameter("c-name");
		String email = req.getParameter("mail");
		String number = req.getParameter("number");
		String about = req.getParameter("about");
		int userId = Integer.parseInt(req.getParameter("sid"));
		ContactDAO dao = new ContactDAO();
		try {
			boolean sts = dao.addContact(new Contact(contactName,email,number,about),userId);
			if(sts == true) {
				HttpSession ss = req.getSession();
				ss.setAttribute("suc-msg-cnt", "Contact added successfully...");
			}
			else {
				HttpSession ss = req.getSession();
				ss.setAttribute("err-msg-cnt", "Something gone wrong on server!!!");
			}
			res.sendRedirect("add-contact.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
