package com.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.management.dto.AdminDTO;
import com.management.dto.EmployeeDTO;
import com.management.dto.GuestDTO;
import com.management.util.DbUtil;

public class LoginDao {

	public static EmployeeDTO validateEmployee(String empName, String password) {
		// TODO Auto-generated method stub
		EmployeeDTO empObj = null;
		try {
			Connection con = DbUtil.getConnection();
			String selectSql="select emp_id , emp_name , mail_id , pswd , country  from employee where \r\n" + 
					" emp_name =? and pswd=? and is_deleted='N' ;";
			
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setString(1 , empName);
			ps.setString(2 , password);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj = new EmployeeDTO();
				empObj.setEmpId(rs.getInt(1));
				empObj.setEmpName(rs.getString(2));
				empObj.setEmpEmail(rs.getString(3));
				empObj.setPassword(rs.getString(4));
				empObj.setCountry(rs.getString(5));
				break;
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return empObj;
	}

	public static AdminDTO validateAdmin(String adminName, String adminPass) {
		// TODO Auto-generated method stub
		AdminDTO adminObj = null;
		try {
			Connection con = DbUtil.getConnection();
			String selectSql="select admin_id , admin_name , admin_email , admin_pswd , country  from admin where \r\n" + 
					" admin_name =? and admin_pswd=? and is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setString(1 , adminName);
			ps.setString(2 , adminPass);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				adminObj = new AdminDTO();
				adminObj.setAdminId(rs.getInt(1));
				adminObj.setAdminName(rs.getString(2));
				adminObj.setAdminEmail(rs.getString(3));
				adminObj.setAdminPass(rs.getString(4));
				adminObj.setCountry(rs.getString(5));
				break;
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return adminObj;
	}

	public static GuestDTO validateGuest(String guestName, String guestPass) {
		// TODO Auto-generated method stub
		GuestDTO guestObj = null;
		try {
			Connection con = DbUtil.getConnection();
			String selectSql="select guest_id , guest_name , guest_mail , guest_pswd , country  from guest where \r\n" + 
					" guest_name =? and guest_pswd=? and is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setString(1 , guestName);
			ps.setString(2 , guestPass);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				guestObj = new GuestDTO();
				guestObj.setGuestId(rs.getInt(1));
				guestObj.setGuestName(rs.getString(2));
				guestObj.setGuestEmail(rs.getString(3));
				guestObj.setGuestPass(rs.getString(4));
				guestObj.setCountry(rs.getString(5));
				break;
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return guestObj;
	}
	
	}
