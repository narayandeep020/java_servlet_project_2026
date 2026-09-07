package com.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.management.dto.AdminDTO;
import com.management.util.DbUtil;

public class AdminDao {

	public static List<AdminDTO> getAdminList() {
		
		List<AdminDTO> adminList = new ArrayList<AdminDTO>();
		AdminDTO adminObj = null;

		try {
			Connection con = DbUtil.getConnection();
			String selectAllSql="select admin_id ,admin_name , admin_email ,admin_pswd , country  from admin where is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectAllSql);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				adminObj = new AdminDTO() ;
				
				adminObj.setAdminId(rs.getInt(1));
				adminObj.setAdminName(rs.getString(2));
				adminObj.setAdminEmail(rs.getString(3));
				adminObj.setAdminPass(rs.getString(4));
				adminObj.setCountry(rs.getString(5));
				
				adminList.add(adminObj);
			}
			
			con.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return adminList;
	}

	public static List<AdminDTO> getAdminByName(String viewAdminName) {
		
		List<AdminDTO> adminList = new ArrayList<AdminDTO>();
		AdminDTO adminObj = null;
		try {
			Connection con = DbUtil.getConnection();
			String selectSql="select admin_id , admin_name , admin_email , admin_pswd , country  from admin where admin_name like ? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setString(1 , viewAdminName + "%");
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				adminObj = new AdminDTO() ;
				
				adminObj.setAdminId(rs.getInt(1));
				adminObj.setAdminName(rs.getString(2));
				adminObj.setAdminEmail(rs.getString(3));
				adminObj.setAdminPass(rs.getString(4));
				adminObj.setCountry(rs.getString(5));
				
				adminList.add(adminObj);
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return adminList;

	}

	public static AdminDTO getAdminById(int adminId) {
		AdminDTO adminObj = new AdminDTO();
		try {
			Connection con = DbUtil.getConnection();
			String selectSql="select admin_id , admin_name , admin_email , admin_pswd , country  from admin where \r\n" + 
					" admin_id =? and is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setInt(1 , adminId);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				adminObj.setAdminId(rs.getInt(1));
				adminObj.setAdminName(rs.getString(2));
				adminObj.setAdminEmail(rs.getString(3));
				adminObj.setAdminPass(rs.getString(4));
				adminObj.setCountry(rs.getString(5));
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return adminObj;
	}

	public static int addAdmin(AdminDTO adm) {
		
		int status = 0;

		try {
			Connection con = DbUtil.getConnection();
			String inserSql="insert into admin (admin_name , admin_email , admin_pswd , country) \r\n" + 
					"value(? , ?, ? , ?) ;";
			PreparedStatement  ps =con.prepareStatement(inserSql);
			
			ps.setString(1 , adm.getAdminName());
			ps.setString(2 , adm.getAdminEmail());
			ps.setString(3 , adm.getAdminPass());
			ps.setString(4 , adm.getCountry());
			
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int updateAdmin(AdminDTO adm) {
		
		int status = 0;
		try {
			Connection con = DbUtil.getConnection();
			String updateSql="update admin e set e.admin_name= ? ,e.admin_email=? ,  \r\n" + 
					"e.admin_pswd=? , e.country=?  where admin_id= ? ;";
			PreparedStatement  ps =con.prepareStatement(updateSql);
			
			ps.setString(1 , adm.getAdminName());
			ps.setString(2 , adm.getAdminEmail());
			ps.setString(3 , adm.getAdminPass());
			ps.setString(4 , adm.getCountry());
			ps.setInt(5 , adm.getAdminId());
			
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int deleteAdmin(int adminId) {
		int status = 0;
		try {
			Connection con = DbUtil.getConnection();
			String deleteSql="update admin e set e.is_deleted='Y' where admin_id= ? ;";
			PreparedStatement  ps =con.prepareStatement(deleteSql);
			ps.setInt(1 , adminId);
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
		
	}

}
