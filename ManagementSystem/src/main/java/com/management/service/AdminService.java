package com.management.service;

import java.util.List;

import com.management.dao.AdminDao;
import com.management.dto.AdminDTO;


public class AdminService {

	public static List<AdminDTO> getAdminList() {		
		return AdminDao.getAdminList();
	}

	
	public static List<AdminDTO> getAdminByName(String viewAdminName) {
		return AdminDao.getAdminByName(viewAdminName);
	}

	
	public static AdminDTO getAdminById(int adminId) {
		return AdminDao.getAdminById(adminId);
	}
	

	public static int addAdmin(AdminDTO adm) {
		String adminName = adm.getAdminName().toUpperCase();		
		adm.setAdminName(adminName);
		
		return  AdminDao.addAdmin(adm);
	}
	

	public static int updateAdmin(AdminDTO adm) {
		String adminName = adm.getAdminName().toUpperCase();
		adm.setAdminName(adminName);
		
        return AdminDao.updateAdmin(adm);
	}
	

	public static void deleteAdmin(int adminId) {
		AdminDao.deleteAdmin(adminId);
	}

}
