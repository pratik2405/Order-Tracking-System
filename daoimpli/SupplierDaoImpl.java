package com.daoimpli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.dao.SupplierDao;
import com.dbconnect.DBConnectOrederTraking;
import com.entity.Supplier;

public class SupplierDaoImpl implements SupplierDao {
	
	Scanner sc=new Scanner(System.in);
	Connection conn;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;
	
	public SupplierDaoImpl()
	{
		try {
			conn=DBConnectOrederTraking.getconnetion();
			st=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addSupplier(com.entity.Supplier s) {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("insert into supplier(sname,address,email,phonono) values(?,?,?,?)");
			pst.setString(1, s.getSname());
			pst.setString(2, s.getAddress());
			pst.setString(3, s.getEmail());
			pst.setLong(4, s.getPhonoNo());
			
			int n=pst.executeUpdate();
			
			if(n>0)
			{
				 System.out.println("Welcome "+s.getSname());
				System.out.println("New Supplier added successfully");
				displaynewsup(s);
			}
			else
				System.out.println("Error to add new supplier !");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displaynewsup(Supplier s)
	{

	    try {
	    	pst=conn.prepareStatement("select * from supplier where sname=?");
	    	pst.setString(1, s.getSname());
	    	
	    	rs=pst.executeQuery();
	    	while(rs.next())
			{
				System.out.println("---------------- New Supplier Details------------");
				System.out.println("Your Supplier Id : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Address : "+rs.getString(3));
				System.out.println("Email id : "+rs.getString(4));
				System.out.println("Phone No : "+rs.getLong(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}

	@Override
	public boolean deleteSupplier(int sid) {
		try {
			int noOfRows=st.executeUpdate("delete from supplier where sid="+sid);
			if(noOfRows>0)
			{
				System.out.println("Supplier " +sid+ " deleted ");
				System.out.println("--------------------------------------------");
			}
			else
			{
				System.out.println("Error to delete supplier !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void viewAllSupplier() {
		// TODO Auto-generated method stub
		try {
			rs=st.executeQuery("select * from supplier");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getString(4)+" - "+rs.getLong(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void viewSupplierById(int sid) {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("select * from supplier where sid=?");
			pst.setInt(1, sid);
			
			rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println("----------------Supplier Details------------");
				System.out.println("Id : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Address : "+rs.getString(3));
				System.out.println("Email id : "+rs.getString(4));
				System.out.println("Phone No : "+rs.getLong(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
