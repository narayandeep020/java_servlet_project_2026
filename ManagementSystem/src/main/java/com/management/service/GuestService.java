package com.management.service;

import java.util.List;

import com.management.dao.GuestDao;
import com.management.dto.GuestDTO;

public class GuestService {

	public static List<GuestDTO> getGuestList() {
		return GuestDao.getGuestList();
	}

	public static List<GuestDTO> getGuestByName(String viewGuestName) {
		return GuestDao.getGuestByName(viewGuestName);
	}

	public static GuestDTO getGuestById(int guestId) {
		return GuestDao.getGuestById(guestId);
	}

	public static int addGuest(GuestDTO guest) {
		String guestName = guest.getGuestName().toUpperCase();		
		guest.setGuestName(guestName);
		
		return  GuestDao.addGuest(guest);
	}

	public static int updateGuest(GuestDTO guest) {
		String adminName = guest.getGuestName().toUpperCase();
		guest.setGuestName(adminName);
		
        return GuestDao.updateGuest(guest);
	}

	public static void deleteGuest(int guestId) {
		GuestDao.deleteGuest(guestId);
	}

}
