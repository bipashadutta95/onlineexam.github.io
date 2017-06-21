package org.servlet;

public class UserPOJO {
	private String fname;
	private String lname;
	private String mno;
	private String emailid;
	private String uname;
	private String pass;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public UserPOJO(String fname, String lname, String mno, String emailid, String uname, String pass) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.mno = mno;
		this.emailid = emailid;
		this.uname = uname;
		this.pass = pass;
	}
	public UserPOJO() {
		super();
	}
}
