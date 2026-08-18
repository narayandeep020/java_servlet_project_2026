package com.emp.system.bean;

public class EmpLoginBean {
	
	private int empID;
	private String empName;
	private String empEmail;
	private String password;
	private String country;
	
	 public EmpLoginBean() {}
	 
    public EmpLoginBean(String empName, String password) {
        this.empName = empName;
        this.password = password;
    }

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
