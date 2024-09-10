package com.entity;

public class Product {
	
	int pid;
	String pname;
	int price;
	int sid;
	
	public Product() {
		
	}

	public Product(int pid, String pname, int price, int sid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.sid = sid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", sid=" + sid + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
