package com.bridgelabz.BankDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.Model.UserBean;

public class BankDAO {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/BankApp?user=root&password=password";
			connection = DriverManager.getConnection(dburl);
		} catch (Exception UserBean) {
			System.out.println(UserBean);
		}
		return connection;
	}

	public String loginUser(String email, String password) {
		try {
			Connection connection = BankDAO.getConnection();
			PreparedStatement pstmt = connection
					.prepareStatement("select * from registration where email=? and password = ?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet resultSet = pstmt.executeQuery();
			System.out.println("Execute Statement :");
				if (resultSet.next()) {
					return resultSet.getString("name");
				}
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		return "false";
	}

	public boolean loginUser(UserBean userbean) throws ClassNotFoundException, SQLException {
		boolean status = false;
		Connection connection = null;
		try {
			connection = BankDAO.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("select * from loginform where email=? and password = ?");
			ps.setString(1, userbean.getEmail());
			ps.setString(2, userbean.getPassword());
			ResultSet rs = ps.executeQuery();

			System.out.println("Execute Statement :");
			status = rs.next();
			System.out.println("status: " + status);
		} finally {
			if (connection != null)
				connection.close();
		}
		return status;
	}

	public static int saveRegistration(UserBean userBean) {
		int status = 0;
		try {
			Connection connection = BankDAO.getConnection();
			String query = "insert into registration (name,email,password,confirmpassword,mobilenumber) values (?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, userBean.getName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());
			pstmt.setString(4, userBean.getConfirmpassword());
			pstmt.setString(5, userBean.getMobilenumber());
			pstmt.executeUpdate();
			connection.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int saveAccountData(UserBean userBean) {
		int status = 0;
		try {
			Connection connection = BankDAO.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("insert into addaccount (id,name,email,city,accountnumber) values(?,?,?,?,?)");
			ps.setInt(1, userBean.getId());
			ps.setString(2, userBean.getName());
			ps.setString(3, userBean.getEmail());
			ps.setString(4, userBean.getCity());
			ps.setInt(5, userBean.getAccountnumber());
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

}
