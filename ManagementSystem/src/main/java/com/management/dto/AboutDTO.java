package com.management.dto;


import java.sql.Timestamp;

public class AboutDTO {

	private int infoId;
	private String sectionTitle;
	private String description;
	private Timestamp createAt;
	private Timestamp updateAt;
	
	public int getInfoId() {
		return infoId;
	}
	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}
	public String getSectionTitle() {
		return sectionTitle;
	}
	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Timestamp timestamp) {
		this.createAt = timestamp;
	}
	public Timestamp getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Timestamp timestamp) {
		this.updateAt = timestamp;
	}
	@Override
	public String toString() {
		return "AboutDTO [infoId=" + infoId + ", sectionTitle=" + sectionTitle + ", description=" + description
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
}
