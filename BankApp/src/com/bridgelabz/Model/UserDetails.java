package com.bridgelabz.Model;

public class UserDetails {

	private int id, accountnumber;
	private String name, email, city, password,confirmpassword,mobilenumber;

	public String getConfirmpassword() {
		return confirmpassword;
	}
	
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}


	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", accountnumber=" + accountnumber + ", name=" + name + ", email=" + email
				+ ", city=" + city + ", password=" + password + ", confirmpassword=" + confirmpassword
				+ ", mobilenumber=" + mobilenumber + "]";
	}

	
	
	

}
