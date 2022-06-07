package com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ContactDAO;

@WebServlet("/delete")
public class DeleteContact extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int sid = Integer.parseInt(req.getParameter("id"));
		ContactDAO dao = new ContactDAO();
		boolean b = false;
		try {
			b = dao.deleteContact(sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		res.sendRedirect("view-contacts.jsp");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doPost(req,res);
	}
}