package com.entity;

public class Customer {

	private int cid;
	private String cname;
	private long phonoNo;
	private String address;
	private int totalorder;
	
	
	public Customer() {
	}
	public Customer(int cid, String cname, long phonoNo,String address, int totalorder) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.phonoNo = phonoNo;
		this.address=address;
		this.totalorder = totalorder;
	}


	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getPhonoNo() {
		return phonoNo;
	}
	public void setPhonoNo(long phonoNo) {
		this.phonoNo = phonoNo;
	}
	public int getTotalorder() {
		return totalorder;
	}
	public void setTotalorder(int totalorder) {
		this.totalorder = totalorder;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", phonoNo=" + phonoNo + "Address ="+address+", totalorder=" + totalorder
				+ "]";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
