package com.emp.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public static int addEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		int status = 0;
		
		try {
			Connection con = DbUtil.getConnection();
			String insertSql = "insert into employee(emp_name, mail_id, pswd, country)\r\n"+"value(?, ?, ?, ?);";
			PreparedStatement pst = con.prepareStatement(insertSql);
			
			pst.setString(1, emp.getEmpName());
			pst.setString(2, emp.getMailId());
			pst.setString(3, emp.getPassword());
			pst.setString(4, emp.getCountry());
			
			status=pst.executeUpdate();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
		return status;
	}

	public static int updateEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		int status = 0;
		
		try {
			Connection con = DbUtil.getConnection();
			String updateSql = "update employee e set e.emp_name=?, e.mail_id=?, \r\n"+"e.pswd=?, e.country=? where emp_id=?;";
			PreparedStatement  ps =con.prepareStatement(updateSql);
			
			ps.setString(1 , emp.getEmpName());
			ps.setString(2 , emp.getMailId());
			ps.setString(3 , emp.getPassword());
			ps.setString(4 , emp.getCountry());
			ps.setInt(5 , emp.getEmpId());
			
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			Connection con = DbUtil.getConnection();
			String deleteSql="update employee e set e.is_deleted='Y' where emp_id= ? ;";
			PreparedStatement  ps =con.prepareStatement(deleteSql);
			ps.setInt(1 , empId);
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static EmployeeDTO getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		EmployeeDTO empObj = new EmployeeDTO();
		try {
			Connection con = DbUtil.getConnection();
			String selectSql = "select emp_id, emp_name, mail_id, pswd, country from employee where \r\n"+"emp_id=? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			
			ps.setInt(1 , empId);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj.setEmpId(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setMailId(rs.getString(3));
				empObj.setPassword(rs.getString(4));
				empObj.setCountry(rs.getString(5));
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empObj;
	}

	public static List<EmployeeDTO> getEmployeeList() {
		// TODO Auto-generated method stub
		List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
		EmployeeDTO empObj = null;
		
		try {
			Connection con = DbUtil.getConnection();
			String selectAllSql="select emp_id ,emp_name , mail_id ,pswd , country  from employee where is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectAllSql);
			ResultSet rs = ps.executeQuery() ;
			
			while(rs.next()) {
				empObj = new EmployeeDTO();
				
				empObj.setEmpId(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setMailId(rs.getString(3));
				empObj.setPassword(rs.getString(4));
				empObj.setCountry(rs.getString(5));
				
				empList.add(empObj);
			}
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	public static List<EmployeeDTO> getEmployeeByName(String viewEmpName) {
		// TODO Auto-generated method stub
		List<EmployeeDTO> empList = new ArrayList<EmployeeDTO>();
		EmployeeDTO empObj = null;
		
		try {
			Connection con = DbUtil.getConnection();
			String selectSqlByName="select emp_id , emp_name , mail_id , pswd , country  from employee where emp_name like ? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSqlByName);
			
			ps.setString(1 , viewEmpName + "%");
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj = new EmployeeDTO() ;
				
				empObj.setEmpId(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setMailId(rs.getString(3));
				empObj.setPassword(rs.getString(4));
				empObj.setCountry(rs.getString(5));
				
				empList.add(empObj);
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return empList;
		
	}
	
}
