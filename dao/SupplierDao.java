package com.dao;

import com.entity.Supplier;

public interface SupplierDao {

	void addSupplier(Supplier s);
	boolean deleteSupplier(int sid);
	void viewAllSupplier();
	void viewSupplierById(int sid);
}
