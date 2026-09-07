package com.management.service;

import java.util.List;

import com.management.dao.EmployeeDao;
import com.management.dto.EmployeeDTO;

public class EmployeeService {

	public static List<EmployeeDTO> getEmployeeList() {
	
		return EmployeeDao.getEmployeeList();
	}

	public static List<EmployeeDTO> getEmployeeByName(String viewEmpName) {
		
		return EmployeeDao.getEmployeeByName(viewEmpName);
	}

	public static EmployeeDTO getEmployeeById(int empId) {
		
		return EmployeeDao.getEmployeeById(empId);
	}

	public static void deleteEmployee(int empId) {
		
		EmployeeDao.deleteEmployee(empId);
	}

	public static int addEmployee(EmployeeDTO emp) {
		
		String empName = emp.getEmpName().toUpperCase();		
		emp.setEmpName(empName);
		
		return  EmployeeDao.addEmployee(emp);
	}

	public static int updateEmployee(EmployeeDTO emp) {
		
		String empName = emp.getEmpName().toUpperCase();
		emp.setEmpName(empName);
		
        return EmployeeDao.updateEmployee(emp);
	}



}
