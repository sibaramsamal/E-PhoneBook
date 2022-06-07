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

@WebServlet("/edit-contact")
public class EditContact extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int cid = Integer.parseInt(req.getParameter("cid"));
		String contactName = req.getParameter("c-name");
		String email = req.getParameter("mail");
		String number = req.getParameter("number");
		String about = req.getParameter("about");
		
		// System.out.println(contactName+" "+email+" "+number+" "+about+" "+cid);
		Contact c = new Contact();
		c.setCid(cid);
		c.setCname(contactName);
		c.setCmail(email);
		c.setPhone(number);
		c.setAbout(about);
		ContactDAO dao = new ContactDAO();
		boolean sts;
		try {
			sts = dao.editContact(c);
		HttpSession ss = req.getSession();
		if (sts == true) {
			ss.setAttribute("suc-msg-edt", "Contact edited successfully...");
			res.sendRedirect("view-contacts.jsp");
		} else {
			ss.setAttribute("err-msg-edt", "Something gone wrong on server!!!");
			res.sendRedirect("edit-contact.jsp?id="+cid);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
