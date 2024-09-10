package com.daoimpli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.app.SupplierApp;
import com.dao.ProductDao;
import com.dbconnect.DBConnectOrederTraking;
import com.entity.Product;

public class ProductDaoImpl implements ProductDao {

	static Scanner sc=new Scanner(System.in);
	Connection conn;
	Statement st;
    PreparedStatement pst;
    ResultSet rs;
    
    public ProductDaoImpl()
    {
    	try {
			conn=DBConnectOrederTraking.getconnetion();
			st=conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

	@Override
	public void addProduct(Product p) {
		
		try {
			pst=conn.prepareStatement("insert into product(pname,price,sid) values (?,?,?)");
			
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setInt(3, p.getSid());
			int n=pst.executeUpdate();
			if(n>0)
			{
				System.out.println();
				System.out.println("Product Added Successfully...");
			}
			else
				System.out.println("Error to adding product");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}

	@Override
	public boolean deleteProduct(int pid) {
		try {
			
			int noOfRowsDelete=st.executeUpdate("delete from product where pid="+pid);
			pst.setInt(1, pid);
			
			if(noOfRowsDelete>0)
				System.out.println("Product deleted");
			else
			{
				System.out.println("Error to deleting product !");
				System.out.println("---------------------------------------------------");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void deleteProductById(int pid, int sid) {
		// TODO Auto-generated method stub
		try {
			
			pst=conn.prepareStatement("delete from product where pid=? AND sid=?");
		    pst.setInt(1, pid);
		    pst.setInt(2, sid);
		    
		    int noOfRow=pst.executeUpdate();
			if(noOfRow>0)
			{
				System.out.println("Product id= "+pid+" deleted");
				System.out.println("--------------------------");
			}
			else
			{
				System.out.println("Product not found !");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void viewAllProduct() {
		// TODO Auto-generated method stub
		try {
			rs=st.executeQuery("select * from product");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3)+" - "+rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void viewProductById(int pid) {
		// TODO Auto-generated method stub
		try {
			rs=st.executeQuery("select * from product where pid="+pid);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3)+" - "+rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void viewProductBySupId(int sid) {
		// TODO Auto-generated method stub
		try {
			rs=st.executeQuery("select * from product where sid="+sid);
			System.out.println("----------- All product details ----------");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProductCost(int pid) {
		// TODO Auto-generated method stub
		try {
			pst=conn.prepareStatement("update product set price=? where pid="+pid);
			
			System.out.println("Enter the price :");
			int price=sc.nextInt();
			pst.setInt(1, price);
			
			int numOfRow=pst.executeUpdate();
			if(numOfRow>0)
			{
				System.out.println("Product price updated successfully");
			}
			else
			{
				System.out.println("Error to update product price !");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
