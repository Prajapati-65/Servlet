package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.BankDAO.BankDAO;

public class DeleteAccount extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("inside delete");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String accountID = req.getParameter("id");
		System.out.println("inside "+accountID);
		int id =Integer.parseInt(accountID);
		BankDAO.deleteAccount(id);
		System.out.println("outside delete");
	}
}




