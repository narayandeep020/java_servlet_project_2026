package com.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.management.dto.GuestDTO;
import com.management.util.DbUtil;

public class GuestDao {

	public static List<GuestDTO> getGuestList() {
		List<GuestDTO> guestList = new ArrayList<GuestDTO>();
		GuestDTO guestObj = null;

		try {
			Connection con = DbUtil.getConnection();
			String selectAllSql="select guest_id ,guest_name , guest_mail ,guest_pswd , country, image  from guest where is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectAllSql);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				guestObj = new GuestDTO() ;
				
				guestObj.setGuestId(rs.getInt(1));
				guestObj.setGuestName(rs.getString(2));
				guestObj.setGuestEmail(rs.getString(3));
				guestObj.setGuestPass(rs.getString(4));
				guestObj.setCountry(rs.getString(5));
				guestObj.setImage(rs.getBytes(6));				
				guestList.add(guestObj);
			}
			
			con.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return guestList;
	}

	public static List<GuestDTO> getGuestByName(String viewGuestName) {
		List<GuestDTO> guestList = new ArrayList<GuestDTO>();
		GuestDTO guestObj = null;
		try {
			Connection con = DbUtil.getConnection();
			String selectSql="select guest_id , guest_name , guest_mail , guest_pswd , country  from guest where guest_name like ? and is_deleted='N';";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setString(1 , viewGuestName + "%");
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				guestObj = new GuestDTO() ;
				
				guestObj.setGuestId(rs.getInt(1));
				guestObj.setGuestName(rs.getString(2));
				guestObj.setGuestEmail(rs.getString(3));
				guestObj.setGuestPass(rs.getString(4));
				guestObj.setCountry(rs.getString(5));
				
				guestList.add(guestObj);
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return guestList;
	}

	public static GuestDTO getGuestById(int guestId) {
		GuestDTO guestObj = new GuestDTO();
		try {
			Connection con = DbUtil.getConnection();
			String selectSql="select guest_id , guest_name , guest_mail , guest_pswd , country, image  from guest where \r\n" + 
					" guest_id =? and is_deleted='N' ;";
			PreparedStatement  ps =con.prepareStatement(selectSql);
			ps.setInt(1 , guestId);
			ResultSet rs = ps.executeQuery() ;
			
			while (rs.next()) {
				guestObj.setGuestId(rs.getInt(1));
				guestObj.setGuestName(rs.getString(2));
				guestObj.setGuestEmail(rs.getString(3));
				guestObj.setGuestPass(rs.getString(4));
				guestObj.setCountry(rs.getString(5));
				guestObj.setImage(rs.getBytes(6));
				
			}
			
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return guestObj;
	}

	public static int addGuest(GuestDTO guest) {
		int status = 0;

		try {
			Connection con = DbUtil.getConnection();
			String inserSql="insert into guest (guest_name , guest_mail , guest_pswd , country, image) \r\n" + 
					"value(? , ?, ? , ?, ?) ;";
			PreparedStatement  ps =con.prepareStatement(inserSql);
			
			ps.setString(1 , guest.getGuestName());
			ps.setString(2 , guest.getGuestEmail());
			ps.setString(3 , guest.getGuestPass());
			ps.setString(4 , guest.getCountry());
			ps.setBytes(5, guest.getImage());
			
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int updateGuest(GuestDTO guest) {
		int status = 0;
		try {
			Connection con = DbUtil.getConnection();
			String updateSql="update guest e set e.guest_name= ? ,e.guest_mail=? ,  \r\n" + 
					"e.guest_pswd=? , e.country=?  where guest_id= ? ;";
			PreparedStatement  ps =con.prepareStatement(updateSql);
			
			ps.setString(1 , guest.getGuestName());
			ps.setString(2 , guest.getGuestEmail());
			ps.setString(3 , guest.getGuestPass());
			ps.setString(4 , guest.getCountry());
			ps.setInt(5 , guest.getGuestId());
			
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int deleteGuest(int guestId) {
		int status = 0;
		try {
			Connection con = DbUtil.getConnection();
			String deleteSql="update guest e set e.is_deleted='Y' where guest_id= ? ;";
			PreparedStatement  ps =con.prepareStatement(deleteSql);
			ps.setInt(1 , guestId);
			status=ps.executeUpdate();  
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
		
	}

}
