package com.daoimpli;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.dao.OrderDao;
import com.dbconnect.DBConnectOrederTraking;
import com.entity.OrderDetails;

public class OrderDaoimpl implements OrderDao {
 
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	static Scanner sc=new Scanner(System.in);
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public OrderDaoimpl() {	
		try {
			conn=DBConnectOrederTraking.getconnetion();
			st=conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public void addOrder(OrderDetails o) {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("insert into orderdetails(cid,pid) values(?,?)");
			pst.setInt(1, o.getCid());
			pst.setInt(2, o.getPid());
			
			int noOfRow=pst.executeUpdate();
			if(noOfRow>0)
			{
				System.out.println("Order Placed Successful");
			}
			else
				System.out.println("Error to place order !");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public Boolean deleteOrder(int orderid) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	@Override
	public void deleteorderbyid(int orderid, int cid) {
		// TODO Auto-generated method stub
		try {
		
			pst=conn.prepareStatement("delete from orderdetails where orderid=? AND cid=?");
		    pst.setInt(1, orderid);
		    pst.setInt(2, cid);
		    
		    int noOfRow=pst.executeUpdate();
			if(noOfRow>0)
			{
				System.out.println("Order id= "+orderid+" deleted");
				System.out.println("--------------------------");
			}
			else
			{
				System.out.println("Order not found !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void viewAllOrder() {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("select * from orderdetails");
			
			rs=pst.executeQuery();
			
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" - "+rs.getInt(2)+" - "+rs.getInt(3)+" - "+rs.getDate(4)+" - "+rs.getString(5)+" - "+rs.getDate(6));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewOrderById(int orderid) {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("select * from orderdetails where orderid=?");
			pst.setInt(1, orderid);
			
			rs=pst.executeQuery();
			
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" - "+rs.getInt(2)+" - "+rs.getInt(3)+" - "+rs.getDate(4)+" - "+rs.getString(5)+" - "+rs.getDate(6));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewOrderByCustomerId(int cid) {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("select * from orderdetails where cid=?");
			pst.setInt(1, cid);
			
			rs=pst.executeQuery();
			
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" - "+rs.getInt(2)+" - "+rs.getInt(3)+" - "+rs.getDate(4)+" - "+rs.getString(5)+" - "+rs.getDate(6));
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewOrderBySupId(int sid) {
		// TODO Auto-generated method stub
		
		try {
			pst=conn.prepareStatement("select * from orderdetails where pid in(select pid from product where sid=?)");
			pst.setInt(1, sid);
			
			rs=pst.executeQuery();
			
			
			while(rs.next())
			{
			System.out.println(rs.getInt(1)+" - "+rs.getInt(2)+" - "+rs.getInt(3)+" - "+rs.getDate(4)+" - "+rs.getString(5)+" - "+rs.getDate(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

	@Override
	public void changeOrderStatus(int orderid) {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("update orderdetails set status=? where orderid="+orderid);
			System.out.println("type status of order :");
			String status=sc.next();
			pst.setString(1, status);
			
			int numOfRow=pst.executeUpdate();
			if(numOfRow>0)
			{
				System.out.println("Order Status Update Successfully");
			}
			else
				System.out.println("Error to change order status !");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
