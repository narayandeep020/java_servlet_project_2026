package com.admincrud;

import java.util.List;


public class AdminService {

	public static int addAdmin(AdminDTO adm) {
		// TODO Auto-generated method stub
		String adminName = adm.getAdminName().toUpperCase();
		adm.setAdminName(adminName);
		return AdminDao.addAdmin(adm);
	}

	public static int updateAdmin(AdminDTO adm) {
		// TODO Auto-generated method stub
		String adminName = adm.getAdminName().toUpperCase();
		adm.setAdminName(adminName);
        return AdminDao.updateAdmin(adm);
	}

	public static void deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		AdminDao.deleteAdmin(adminId);
	}

	public static List<AdminDTO> getAdminByName(String viewAdminName) {
		// TODO Auto-generated method stub
		return AdminDao.getAdminByName(viewAdminName);
	}

	public static AdminDTO getAdminById(int adminId) {
		// TODO Auto-generated method stub
		return AdminDao.getAdminById(adminId);
	}

	public static List<AdminDTO> getAdminList() {
		// TODO Auto-generated method stub
		return AdminDao.getAdminList();
	}
}
