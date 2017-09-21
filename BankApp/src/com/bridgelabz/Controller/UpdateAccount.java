package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.UserDetails;

//@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        int accountNo = Integer.parseInt(req.getParameter("accountnumber"));
        String email = req.getParameter("email");
        String city = req.getParameter("city");
        int id=Integer.parseInt(req.getParameter("id"));
		
        UserDetails user = new UserDetails();
        user.setName(name);
        user.setEmail(email);
        user.setCity(city);
        user.setAccountnumber(accountNo);
        user.setId(id);
     
        int status = BankDAO.updateAccount1(id);
        
		if(status > 0)
		{
			resp.sendRedirect("homePage.jsp");
		}
		else
		{
			out.println("sorry unable to update");
		}
	}

}
