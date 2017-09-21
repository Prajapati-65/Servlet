package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.BankDAO.BankDAO;

//@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		System.out.println("Inside delete acconut");
		String emailId = req.getParameter("email");
		BankDAO.deleteAccount(emailId);
		System.out.println("Account deleted");
	}
}




