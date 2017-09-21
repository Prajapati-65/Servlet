package com.bridgelabz.Controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.UserDetails;

//@WebServlet("/AddAccountDetails")
public class AddAccountDetails extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = ("<br>" + "Your account is successful" + "</br>");
		out.println(title);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		String number = req.getParameter("accountnumber");
		int accountNumber = Integer.parseInt(number);
		UserDetails user = new UserDetails();
		user.setName(name);
		user.setEmail(email);
		user.setCity(city);
		user.setAccountnumber(accountNumber);
		
		if (BankDAO.saveAccountData(user) > 0) {
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			session.setAttribute("email", email);
			session.setAttribute("city", city);
			session.setAttribute("accountnumber", number);
			resp.sendRedirect("homepage.jsp");

		} else {
			out.println("Sorry unable to save record");
		}
	}
}
