package com.bridgelabz.BankDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.UEncoder;

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "false";
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
	
	public static List<UserBean> getAllAccount(String city) {
		List<UserBean> list = new ArrayList<UserBean>();
		try {
			Connection con = BankDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from addaccount where city = ?");
			ps.setString(1, city);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserBean userBean = new UserBean();
				userBean.setId(rs.getInt(1));
				userBean.setName(rs.getString(2));
				userBean.setEmail(rs.getString(3));
				userBean.setCity(rs.getString(4));
				userBean.setAccountnumber(rs.getInt(5));
				list.add(userBean);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static UserBean getAccountID(int id) {
		UserBean loginBean = new UserBean();
		try {
			Connection con = BankDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from addaccount  where id = ? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				loginBean.setId(rs.getInt(1));
				loginBean.setName(rs.getString(2));
				loginBean.setEmail(rs.getString(3));
				loginBean.setCity(rs.getString(4));
				loginBean.setAccountnumber(rs.getInt(6));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return loginBean;
	}

	
	public static int deleteAccount(int id) {
		int status = 0;
		try {
			Connection con = BankDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from addaccount where id = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int updateAccount(UserBean userBean) {
		System.out.println("Account Id : " + userBean.getId());
		int status = 0;
		try {
			Connection con = BankDAO.getConnection();
			PreparedStatement preparetatement = con
					.prepareStatement("update addaccount set name=?,email=?,city=?,account=? where id=?");
			System.out.println("City Name" + userBean.getCity());
			preparetatement.setInt(1, userBean.getId());
			preparetatement.setString(2, userBean.getName());
			preparetatement.setString(3, userBean.getEmail());
			preparetatement.setString(4, userBean.getCity());
			preparetatement.setInt(5, userBean.getAccountnumber());
			status = preparetatement.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	
	
}
