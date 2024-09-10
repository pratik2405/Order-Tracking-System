package com.dao;

import com.entity.Product;

public interface ProductDao {

	void addProduct(Product p);
	boolean deleteProduct(int pid);
	void deleteProductById(int pid,int sid);
	void viewAllProduct();
	void viewProductById(int pid);
	void viewProductBySupId(int sid);
	void updateProductCost(int sid);
}
