package com.model;

public class Contact {
	int cid;
	String cname;
	String phone;
	String cmail;
	String about;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Contact(String cname, String cmail, String phone, String about) {
		super();
		this.cname = cname;
		this.phone = phone;
		this.cmail = cmail;
		this.about = about;
	}
	public Contact() {
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCmail() {
		return cmail;
	}
	public void setCmail(String cmail) {
		this.cmail = cmail;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
}
