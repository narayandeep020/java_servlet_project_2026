package com.emp.system.service;

import java.util.List;

import com.emp.system.bean.EmpLoginBean;
import com.emp.system.dao.EmpLoginDao;

public class EmpLoginService {

	private EmpLoginDao dao = new EmpLoginDao();
	
	public boolean validateCredential(EmpLoginBean bean) {
		 
		return dao.validateCredential(bean);
		 
	}

	public static EmpLoginBean getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return EmpLoginDao.getEmployeeById(empId);
	}

	public static List<EmpLoginBean> getEmployeeByName(String viewEmpName) {
		// TODO Auto-generated method stub
		return EmpLoginDao.getEmployeeByName(viewEmpName);
	}

	public static List<EmpLoginBean> getEmployeeList() {
		// TODO Auto-generated method stub
		return EmpLoginDao.getEmployeeList();
	}

	public static int addEmployee(EmpLoginBean emp) {
		// TODO Auto-generated method stub
		String empName = emp.getEmpName().toUpperCase();
		emp.setEmpName(empName);
		return EmpLoginDao.addEmployee(emp);
	}

	public static int updateEmployee(EmpLoginBean emp) {
		// TODO Auto-generated method stub
		String empName = emp.getEmpName().toUpperCase();
		emp.setEmpName(empName);
        return EmpLoginDao.updateEmployee(emp);
	}

	public static void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		EmpLoginDao.deleteEmployee(empId);
	}
}
