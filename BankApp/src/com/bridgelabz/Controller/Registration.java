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
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.xml.bind.ParseConversionEvent;


public class Registration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = "Welcome to Bridgelabz";
		out.println(title);
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/BankApp?user=root&password=password";
			con = DriverManager.getConnection(dburl);
			String query ="insert into registration values (?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			
			String number =req.getParameter("number");
			int mobilenumber = Integer.parseInt(number);
			String name = req.getParameter("name");
			String email =req.getParameter("email");
			String password = req.getParameter("password");
			String confirmpassword =req.getParameter("password");
			
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, confirmpassword);
			pstmt.setInt(5, mobilenumber);
			pstmt.executeUpdate();
		
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null)
					con.close();
				if(pstmt!=null)
					pstmt.close();
				
			} catch (Exception e2) {
			}
		}
	}

}
