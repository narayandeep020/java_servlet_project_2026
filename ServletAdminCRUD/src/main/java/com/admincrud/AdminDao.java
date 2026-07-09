package com.admincrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class AdminDao {

	public static int addAdmin(AdminDTO admin) {
		// TODO Auto-generated method stub
       int status = 0;
		
		try {
			Connection con = DbAdminUtil.getConnection();
			String insertSql = "insert into admin(admin_name, admin_email, admin_pswd, country)\r\n"+"value(?, ?, ?, ?);";
			PreparedStatement pst = con.prepareStatement(insertSql);
			
			pst.setString(1, admin.getAdminName());
			pst.setString(2, admin.getMailId());
			pst.setString(3, admin.getPassword());
			pst.setString(4, admin.getCountry());
			
			status=pst.executeUpdate();
			con.close();
		}catch(Exception e) {e.printStackTrace();}
		return status;
	}

	public static int updateAdmin(AdminDTO admin) {
		// TODO Auto-generated method stub
        int status = 0;
		
		try {
			Connection con = DbAdminUtil.getConnection();
			String updateSql = "update admin e set e.admin_name=?, e.admin_email=?, \r\n"+"e.admin_pswd=?, e.country=? where admin_id=?;";
			PreparedStatement  ps =con.prepareStatement(updateSql);
			
			ps.setString(1 , admin.getAdminName());
			ps.setString(2 , admin.getMailId());
			ps.setString(3 , admin.getPassword());
			ps.setString(4 , admin.getCountry());
			ps.setInt(5 , admin.getAdminId());
			
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			Connection con = DbAdminUtil.getConnection();
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

	public static List<AdminDTO> getAdminByName(String viewAdminName) {
		// TODO Auto-generated method stub
		List<AdminDTO> empList = new ArrayList<AdminDTO>();
		AdminDTO empObj = null;
		
		try {
			Connection con = DbAdminUtil.getConnection();
			String selectSqlByName="select admin_id , admin_name , admin_email, admin_pswd, country  from admin where admin_name like ? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSqlByName);
			
			ps.setString(1 , viewAdminName + "%");
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj = new AdminDTO() ;
				
				empObj.setAdminId(rs.getInt(1));
				empObj.setAdminName(rs.getString(2));
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

	public static AdminDTO getAdminById(int adminId) {
		// TODO Auto-generated method stub
		AdminDTO empObj = new AdminDTO();
		try {
			Connection con = DbAdminUtil.getConnection();
			String selectSql = "select admin_id, admin_name, admin_email, admin_pswd, country from admin where \r\n"+"admin_id=? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			
			ps.setInt(1 , adminId);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj.setAdminId(rs.getInt(1));
				empObj.setAdminName(rs.getString(2));
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

	public static List<AdminDTO> getAdminList() {
		// TODO Auto-generated method stub
		List<AdminDTO> empList = new ArrayList<AdminDTO>();
		AdminDTO empObj = null;
		
		try {
			Connection con = DbAdminUtil.getConnection();
			String selectAllSql="select admin_id ,admin_name , admin_email, admin_pswd , country  from admin where is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectAllSql);
			ResultSet rs = ps.executeQuery() ;
			
			while(rs.next()) {
				empObj = new AdminDTO();
				
				empObj.setAdminId(rs.getInt(1));
				empObj.setAdminName(rs.getString(2));
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

}
