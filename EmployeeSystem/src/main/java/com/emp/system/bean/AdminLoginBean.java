package com.emp.system.bean;

public class AdminLoginBean {

	private int adminId;
	private String adminName;
	private String adminEmail;
	private String adminPass;
	private String country;
	
	public AdminLoginBean() {}
	
	public AdminLoginBean(String adminName, String adminPass) {
		this.adminName = adminName;
		this.adminPass = adminPass;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AdminLoginBean [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail
				+ ", adminPass=" + adminPass + ", country=" + country + "]";
	}
	
}
