package com.entity;

public class Supplier {
	private int sid;
	private String sname;
	private String address;
	private String email;
	private long phonoNo;
	
	
	public Supplier() {
		
	}

	public Supplier(int sid, String sname, String address, String email, long phonoNo) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address = address;
		this.email = email;
		this.phonoNo = phonoNo;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonoNo() {
		return phonoNo;
	}

	public void setPhonoNo(long phonoNo) {
		this.phonoNo = phonoNo;
	}

	@Override
	public String toString() {
		return "Supplier [sid=" + sid + ", sname=" + sname + ", address=" + address + ", email=" + email + ", phonoNo="
				+ phonoNo + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
