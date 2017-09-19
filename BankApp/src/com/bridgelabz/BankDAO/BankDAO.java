package com.bridgelabz.BankDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.UEncoder;

import com.bridgelabz.Model.UserDetails;

public class BankDAO {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/BankApp?user=root&password=password";
			connection = DriverManager.getConnection(dburl);
		} catch (Exception user) {
			System.out.println(user);
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

	public static int saveRegistration(UserDetails user) {
		int status = 0;
		try {
			Connection connection = BankDAO.getConnection();
			String query = "insert into registration (name,email,password,confirmpassword,mobilenumber) values (?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getConfirmpassword());
			pstmt.setString(5, user.getMobilenumber());
			pstmt.executeUpdate();
			connection.close();
			pstmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int saveAccountData(UserDetails user) {
		int status = 0;
		try {
			Connection connection = BankDAO.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("insert into addaccount (name,email,city,accountnumber) values(?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCity());
			ps.setInt(4, user.getAccountnumber());
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}
	
	public static List<UserDetails> getAllAccount(String city) {
		List<UserDetails> list = new ArrayList<UserDetails>();
		try {
			Connection con = BankDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from addaccount where city = ?");
			ps.setString(1, city);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UserDetails user = new UserDetails();
				user.setId(rs.getInt(5));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setCity(rs.getString(4));
				user.setAccountnumber(rs.getInt(5));
				list.add(user);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	public static int deleteAccount(int id) {
		System.out.println("hello delete");
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
	
	
	public static UserDetails getUserByEmail(String email) {
		UserDetails user = new UserDetails();
		try {
			Connection con = BankDAO.getConnection();
			PreparedStatement preparetatement = con
					.prepareStatement("select * from addaccount where email = ?");
			preparetatement.setString(1, email);
			ResultSet rs =preparetatement.executeQuery();
			if (rs.next()) {
				user.setName(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setCity(rs.getString(3));
				user.setAccountnumber(rs.getInt(4));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}

	
	public static int updateAccount(UserDetails user) {
		int status = 0;
		try {
			Connection con = BankDAO.getConnection();
			PreparedStatement preparetatement = con
					.prepareStatement("update addaccount set name=?,city=?,accountnumber=? where email=?");
			preparetatement.setString(1, user.getName());
			preparetatement.setString(2, user.getCity());
			preparetatement.setInt(3, user.getAccountnumber());
			preparetatement.setString(4, user.getEmail());
			status = preparetatement.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	
	
}
