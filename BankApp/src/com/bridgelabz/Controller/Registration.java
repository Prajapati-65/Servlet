package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.UserBean;


public class Registration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = ("<br>"+"Your registration is successful...."+"</br>");
		out.println(title);	
		
		String name = req.getParameter("name");
		String email =req.getParameter("email");
		String password = req.getParameter("password");
		String confirmpassword =req.getParameter("confirmpassword");
		String number =req.getParameter("mobilenumber");
		UserBean userBean = new UserBean();
		
		userBean.setName(name);
		userBean.setEmail(email);
		userBean.setPassword(password);
		userBean.setConfirmpassword(confirmpassword);
		userBean.setMobilenumber(number);
		BankDAO.saveRegistration(userBean);
		
	}

}
