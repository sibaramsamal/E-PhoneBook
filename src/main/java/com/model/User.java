package com.model;

import java.io.Serializable;

public class User implements Serializable{
	int uid;
	String uname;
	String email;
	String password;
	
	public User(String uname, String email, String password) {
		super();
		this.uname = uname;
		this.email = email;
		this.password = password;
	}
	public User() {
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
