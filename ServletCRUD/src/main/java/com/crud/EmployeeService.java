package com.crud;

import java.util.List;

public class EmployeeService {

	public static EmployeeDTO getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return EmployeeDao.getEmployeeById(empId);
	}

	public static List<EmployeeDTO> getEmployeeByName(String viewEmpName) {
		// TODO Auto-generated method stub
		return EmployeeDao.getEmployeeByName(viewEmpName);
	}

	public static List<EmployeeDTO> getEmployeeList() {
		// TODO Auto-generated method stub
		return EmployeeDao.getEmployeeList();
	}

	public static int addEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		String empName = emp.getEmpName().toUpperCase();
		emp.setEmpName(empName);
		return EmployeeDao.addEmployee(emp);
	}

	public static int updateEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		String empName = emp.getEmpName().toUpperCase();
		emp.setEmpName(empName);
        return EmployeeDao.updateEmployee(emp);
	}

	public static void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		EmployeeDao.deleteEmployee(empId);
	}

	
}
