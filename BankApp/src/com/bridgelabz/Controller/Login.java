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

public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = "Hello bridgelabz";
		out.print(title);
		Connection con = null;
		PreparedStatement pstmt =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/BankApp?user=root&password=password";
			con = DriverManager.getConnection(dburl);
			String query ="insert into loginform values (?,?)";
			pstmt=con.prepareStatement(query);
			String email =req.getParameter("email");
			String password = req.getParameter("password");
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
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
