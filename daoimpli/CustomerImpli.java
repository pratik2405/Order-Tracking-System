package com.daoimpli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.dao.CustomerDao;
import com.dbconnect.DBConnectOrederTraking;
import com.entity.Customer;

public class CustomerImpli implements CustomerDao {

	Scanner sc=new Scanner(System.in);
	Connection conn;
	PreparedStatement pst;
	Statement st;
	ResultSet rs;

    public CustomerImpli() {
	
    	try {
    		conn=DBConnectOrederTraking.getconnetion();
			st=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Override
	public void addcustomer(Customer c) {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("insert into customer(cname,phonono,address) values(?,?,?)");
			pst.setString(1, c.getCname());
			pst.setLong(2, c.getPhonoNo());
			pst.setString(3, c.getAddress());

			int n=pst.executeUpdate();
			if(n>0)
			{
				System.out.println(" New customer added successfully .");
				displaynewcust(c);
			}
			else
				System.out.println("Error to add new customer !");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displaynewcust(Customer c)
	{
		try {
			pst=conn.prepareStatement("select cid,cname,phonono,address from customer where cname=?");
			pst.setString(1, c.getCname());
			
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				System.out.println("--------------- Details ------------------");
				System.out.println("Your Customer id ="+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println( "Mobile no :"+rs.getLong(3));
				System.out.println( "Address"+rs.getString(4));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void viewAllCustomer() {
		// TODO Auto-generated method stub
		
		try {
			pst=conn.prepareStatement("select * from customer");
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getLong(3)+" - "+rs.getString(4)+" - "+rs.getInt(5));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void viewCustomerById(int cid) {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("select * from customer where cid=?");
			pst.setInt(1, cid);
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getLong(3)+" - "+rs.getString(4)+" - "+rs.getInt(5));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
