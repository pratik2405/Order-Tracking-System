package com.dao;

import com.entity.Customer;

public interface CustomerDao {

	void addcustomer(Customer c);
	boolean deleteCustomer(int cid);
	void viewAllCustomer();
	void viewCustomerById(int cid);
}
