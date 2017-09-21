package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.UserDetails;

//@WebServlet("/Login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserDetails user = new UserDetails();
		user.setEmail(email);
		user.setPassword(password);
		
		BankDAO bankdao = new BankDAO();
		String name = bankdao.loginUser(email, password);
		System.out.println(name);
		if (name != "false") 
		{
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			resp.sendRedirect("homepage.jsp");
		} 
		else {
			resp.sendRedirect("login.jsp");
		}
	}
}
