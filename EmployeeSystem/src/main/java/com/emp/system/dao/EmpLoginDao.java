package com.emp.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emp.system.bean.EmpLoginBean;
import com.emp.system.util.DbUtil;


public class EmpLoginDao {
	
	public boolean validateCredential(EmpLoginBean bean) {
		boolean status = false;
	        try (Connection con = DbUtil.getConn()) {
	            String query = "SELECT * FROM employee WHERE emp_name=? AND pswd=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, bean.getEmpName());
	            ps.setString(2, bean.getPassword());

	            ResultSet rs = ps.executeQuery();
	            status =  (rs.next());   
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return status;
	}

	public static EmpLoginBean getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		EmpLoginBean empObj = new EmpLoginBean();
		try {
			Connection con = DbUtil.getConn();
			String selectSql = "select emp_id, emp_name, mail_id, pswd, country from employee where \r\n"+"emp_id=? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			
			ps.setInt(1 , empId);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj.setEmpID(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setEmpEmail(rs.getString(3));
				empObj.setPassword(rs.getString(4));
				empObj.setCountry(rs.getString(5));
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empObj;
	}

	public static List<EmpLoginBean> getEmployeeByName(String viewEmpName) {
		// TODO Auto-generated method stub
		List<EmpLoginBean> empList = new ArrayList<EmpLoginBean>();
		EmpLoginBean empObj = null;
		
		try {
			Connection con = DbUtil.getConn();
			String selectSqlByName="select emp_id , emp_name , mail_id , pswd , country  from employee where emp_name like ? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSqlByName);
			
			ps.setString(1 , viewEmpName + "%");
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj = new EmpLoginBean() ;
				
				empObj.setEmpID(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setEmpEmail(rs.getString(3));
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

	public static List<EmpLoginBean> getEmployeeList() {
		// TODO Auto-generated method stub
		List<EmpLoginBean> empList = new ArrayList<EmpLoginBean>();
		EmpLoginBean empObj = null;
		
		try {
			Connection con = DbUtil.getConn();
			String selectAllSql="select emp_id ,emp_name , mail_id ,pswd , country  from employee where is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectAllSql);
			ResultSet rs = ps.executeQuery() ;
			
			while(rs.next()) {
				empObj = new EmpLoginBean();
				
				empObj.setEmpID(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setEmpEmail(rs.getString(3));
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

	public static int addEmployee(EmpLoginBean emp) {
		// TODO Auto-generated method stub
		int status = 0;
		
		try {
			Connection con = DbUtil.getConn();
			String insertSql = "insert into employee(emp_name, mail_id, pswd, country)\r\n"+"value(?, ?, ?, ?);";
			PreparedStatement pst = con.prepareStatement(insertSql);
			
			pst.setString(1, emp.getEmpName());
			pst.setString(2, emp.getEmpEmail());
			pst.setString(3, emp.getPassword());
			pst.setString(4, emp.getCountry());
			
			status=pst.executeUpdate();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
		return status;
	}

	public static int updateEmployee(EmpLoginBean emp) {
		// TODO Auto-generated method stub
	int status = 0;
		
		try {
			Connection con = DbUtil.getConn();
			String updateSql = "update employee e set e.emp_name=?, e.mail_id=?, \r\n"+"e.pswd=?, e.country=? where emp_id=?;";
			PreparedStatement  ps =con.prepareStatement(updateSql);
			
			ps.setString(1 , emp.getEmpName());
			ps.setString(2 , emp.getEmpEmail());
			ps.setString(3 , emp.getPassword());
			ps.setString(4 , emp.getCountry());
			ps.setInt(5 , emp.getEmpID());
			
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
			Connection con = DbUtil.getConn();
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
}
