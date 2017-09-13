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

public class AddAccount extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String add = "Account added";
		out.println(add);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/BankApp?user=root&password=password";
			con = DriverManager.getConnection(dburl);
			String query = "insert into addaccount values(?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			String id = req.getParameter("id");
			int inputId = Integer.parseInt(id);
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String city = req.getParameter("city");
			String number = req.getParameter("account");
			int accountNumber = Integer.parseInt(number);
			pstmt.setInt(1, inputId);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, city);
			pstmt.setInt(5, accountNumber);
			pstmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				
			}
		}

	}
}
