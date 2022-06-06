package com.controllers;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession ss = req.getSession();
		ss.removeAttribute("User");
		res.sendRedirect("index.jsp");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doPost(req,res);
	}
}
