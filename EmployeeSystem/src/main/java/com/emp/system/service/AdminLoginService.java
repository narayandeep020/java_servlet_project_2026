package com.emp.system.service;

import java.util.List;

import com.emp.system.bean.AdminLoginBean;
import com.emp.system.dao.AdminLoginDao;

public class AdminLoginService {

private AdminLoginDao dao = new AdminLoginDao();
	
	public boolean validateCredential(AdminLoginBean bean) {
		 
		return dao.validateCredential(bean);
}

	public static List<AdminLoginBean> getAdminList() {
		return AdminLoginDao.getAdminList();
	}

	public static AdminLoginBean getAdminById(int adminId) {
		return AdminLoginDao.getAdminById(adminId);
	}

	public static void deleteAdmin(int adminId) {
		AdminLoginDao.deleteAdmin(adminId);
		
	}

	public static int updateAdmin(AdminLoginBean adm) {
		String adminName = adm.getAdminName().toUpperCase();
		adm.setAdminName(adminName);
        return AdminLoginDao.updateAdmin(adm);
	}

	public static int addAdmin(AdminLoginBean adm) {
		String adminName = adm.getAdminName().toUpperCase();
		adm.setAdminName(adminName);
		return AdminLoginDao.addAdmin(adm);
	}

	public static List<AdminLoginBean> getAdminByName(String viewAdminName) {
		return AdminLoginDao.getAdminByName(viewAdminName);
	}
}
