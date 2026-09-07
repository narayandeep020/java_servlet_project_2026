package com.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.management.dto.AboutDTO;
import com.management.util.DbUtil;

public class AboutDao {

	public List<AboutDTO> getAllAboutSections() throws Exception {
		
		List<AboutDTO> list = new ArrayList<AboutDTO>();
		AboutDTO about = null;
        
		try {
			Connection conn = DbUtil.getConnection();
			String selectAllSql = "SELECT * FROM aboutus;";
			PreparedStatement  ps =conn.prepareStatement(selectAllSql);
			ResultSet rs = ps.executeQuery();
			
            while (rs.next()) {
                about = new AboutDTO();
                
                about.setInfoId(rs.getInt("infoId"));
                about.setSectionTitle(rs.getString("section_title"));
                about.setDescription(rs.getString("description"));
                about.setCreateAt(rs.getTimestamp("created_at"));
                about.setUpdateAt(rs.getTimestamp("updated_at"));

                
                list.add(about);
            }
            conn.close();
        }catch (Exception ex) {
			ex.printStackTrace();
		}
        return list;
	}

	
}
