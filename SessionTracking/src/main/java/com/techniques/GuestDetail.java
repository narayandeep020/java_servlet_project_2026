package com.techniques;

public class GuestDetail {

	public GuestDetail() {
		// TODO Auto-generated constructor stub
	}

	private String guestName;
	private String guestCity;
	private String guestId;
	
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestCity() {
		return guestCity;
	}
	public void setGuestCity(String guestCity) {
		this.guestCity = guestCity;
	}
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	@Override
	public String toString() {
		return "GuestDetail [guestName=" + guestName + ", guestCity=" + guestCity + ", guestId=" + guestId
				+ "]";
	}
	
	
}