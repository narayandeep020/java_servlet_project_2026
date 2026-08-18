package com.emp.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.emp.system.bean.AdminLoginBean;
import com.emp.system.util.DbUtil;

public class AdminLoginDao {

	public boolean validateCredential(AdminLoginBean bean) {
		boolean status = false;
	        try (Connection con = DbUtil.getConn()) {
	            String query = "SELECT admin_name, admin_pswd FROM admin WHERE admin_name=? AND admin_pswd=?";
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setString(1, bean.getAdminName());
	            ps.setString(2, bean.getAdminPass());

	            ResultSet rs = ps.executeQuery();
	            status =  (rs.next());   
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return status;
	}

	public static int addAdmin(AdminLoginBean adm) {
	       int status = 0;
			
			try {
				Connection con = DbUtil.getConn();
				String insertSql = "insert into admin(admin_name, admin_email, admin_pswd, country)"+"value(?, ?, ?, ?);";
				PreparedStatement pst = con.prepareStatement(insertSql);
				
				pst.setString(1, adm.getAdminName());
				pst.setString(2, adm.getAdminEmail());
				pst.setString(3, adm.getAdminPass());
				pst.setString(4, adm.getCountry());
				
				status=pst.executeUpdate();
				con.close();
			}catch(Exception e) {e.printStackTrace();}
			return status;
		}
	

	public static List<AdminLoginBean> getAdminList() {
		List<AdminLoginBean> empList = new ArrayList<AdminLoginBean>();
		AdminLoginBean empObj = null;
		
		try {
			Connection con = DbUtil.getConn();
			String selectAllSql="select admin_id ,admin_name , admin_email, admin_pswd , country  from admin where is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectAllSql);
			ResultSet rs = ps.executeQuery() ;
			
			while(rs.next()) {
				empObj = new AdminLoginBean();
				
				empObj.setAdminId(rs.getInt(1));
				empObj.setAdminName(rs.getString(2));
				empObj.setAdminEmail(rs.getString(3));
				empObj.setAdminPass(rs.getString(4));
				empObj.setCountry(rs.getString(5));
				
				empList.add(empObj);
			}
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	public static AdminLoginBean getAdminById(int adminId) {
		AdminLoginBean empObj = new AdminLoginBean();
		try {
			Connection con = DbUtil.getConn();
			String selectSql = "select admin_id, admin_name, admin_email, admin_pswd, country from admin where admin_id=? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			
			ps.setInt(1 , adminId);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj.setAdminId(rs.getInt(1));
				empObj.setAdminName(rs.getString(2));
				empObj.setAdminEmail(rs.getString(3));
				empObj.setAdminPass(rs.getString(4));
				empObj.setCountry(rs.getString(5));
			}
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return empObj;
	}

	public static int deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		int status = 0;
		try {
			Connection con = DbUtil.getConn();
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

	public static int updateAdmin(AdminLoginBean adm) {
int status = 0;
		
		try {
			Connection con = DbUtil.getConn();
			String updateSql = "update admin e set e.admin_name=?, e.admin_email=?, \r\n"+"e.admin_pswd=?, e.country=? where admin_id=?;";
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

	public static List<AdminLoginBean> getAdminByName(String viewAdminName) {
		List<AdminLoginBean> empList = new ArrayList<AdminLoginBean>();
		AdminLoginBean empObj = null;
		
		try {
			Connection con = DbUtil.getConn();
			String selectSqlByName="select admin_id , admin_name , admin_email, admin_pswd, country  from admin where admin_name like ? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSqlByName);
			
			ps.setString(1 , viewAdminName + "%");
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				empObj = new AdminLoginBean() ;
				
				empObj.setAdminId(rs.getInt(1));
				empObj.setAdminName(rs.getString(2));
				empObj.setAdminEmail(rs.getString(3));
				empObj.setAdminPass(rs.getString(4));
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
