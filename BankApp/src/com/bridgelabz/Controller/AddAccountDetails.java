package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.UserBean;

public class AddAccountDetails extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = ("<br>" + "Your account is successful" + "</br>");
		out.println(title);
		String id = req.getParameter("id");
		int accId = Integer.parseInt(id);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		String number = req.getParameter("accountnumber");
		int accountNumber = Integer.parseInt(number);
		UserBean userBean = new UserBean();
		userBean.setId(accId);
		userBean.setName(name);
		userBean.setEmail(email);
		userBean.setCity(city);
		userBean.setAccountnumber(accountNumber);
		
		if (BankDAO.saveAccountData(userBean) > 0) {
			out.print("Record Saved Successfully");
			resp.sendRedirect("homepage.jsp");

		} else {
			out.println("Sorry unable to save record");
		}
	}
}
