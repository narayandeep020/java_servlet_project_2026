package com.management.dto;


public class GuestDTO {

	private int guestId;
	private String guestName;
	private String guestEmail;
	private String guestPass;
	private String country;
	private byte[] image;
	
	
	public int getGuestId() {
		return guestId;
	}
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestEmail() {
		return guestEmail;
	}
	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}
	public String getGuestPass() {
		return guestPass;
	}
	public void setGuestPass(String guestPass) {
		this.guestPass = guestPass;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	@Override
	public String toString() {
		return "GuestDTO [guestId=" + guestId + ", guestName=" + guestName + ", guestEmail=" + guestEmail + ", country="
				+ country + "]";
	}
	
	
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
