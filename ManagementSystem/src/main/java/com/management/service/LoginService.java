package com.management.service;

import com.management.dao.LoginDao;
import com.management.dto.AdminDTO;
import com.management.dto.EmployeeDTO;
import com.management.dto.GuestDTO;

public class LoginService {

	public static AdminDTO validateAdmin(String adminName, String adminPass) {
		// TODO Auto-generated method stub
		return LoginDao.validateAdmin(adminName, adminPass);
	}

	public static EmployeeDTO validateEmployee(String empName, String password) {
		// TODO Auto-generated method stub
		return LoginDao.validateEmployee(empName, password);
	}

	public static GuestDTO validateGuest(String guestName, String guestPass) {
		// TODO Auto-generated method stub
		return LoginDao.validateGuest(guestName, guestPass);
	}
}
