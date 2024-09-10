package com.dao;

import com.entity.OrderDetails;


public interface OrderDao {

	void addOrder(OrderDetails o);
	Boolean deleteOrder(int orderid);
	void deleteorderbyid(int orderid,int cid);
	void viewAllOrder();
	void viewOrderById(int orderid);
	void viewOrderByCustomerId(int cid);
	void viewOrderBySupId(int sid);
	void changeOrderStatus(int orderid);
}
