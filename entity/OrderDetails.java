package com.entity;

import java.util.Date;

public class OrderDetails {
	
	private int orderid;
	private int cid;
	private int pid;
	private Date dateOfOreder;
	private String status;
	private Date deliveredDate;
	
	public OrderDetails()
	{
		
	}

	public OrderDetails(int orderid, int cid, int pid, Date dateOfOreder, String status, Date deliveredDate) {
		super();
		this.orderid = orderid;
		this.cid = cid;
		this.pid = pid;
		this.dateOfOreder = dateOfOreder;
		this.status = status;
		this.deliveredDate = deliveredDate;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Date getDateOfOreder() {
		return dateOfOreder;
	}

	public void setDateOfOreder(Date dateOfOreder) {
		this.dateOfOreder = dateOfOreder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderid=" + orderid + ", cid=" + cid + ", pid=" + pid + ", dateOfOreder=" + dateOfOreder
				+ ", status=" + status + ", deliveredDate=" + deliveredDate + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
