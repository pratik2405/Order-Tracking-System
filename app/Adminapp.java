package com.app;

import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.OrderDao;
import com.dao.SupplierDao;
import com.daoimpli.CustomerImpli;
import com.daoimpli.OrderDaoimpl;
import com.daoimpli.SupplierDaoImpl;

public class Adminapp {

	static Scanner sc=new Scanner(System.in);
	SupplierDao sd=new SupplierDaoImpl();
	CustomerDao cd=new CustomerImpli();
	OrderDao od=new OrderDaoimpl();
	
	public void adminsupplier()
	{
		int choice;
		char ch;
		int sid;
		do {
			System.out.println("------------------------------------------------------");
			System.out.println("1-View all supplier");
			System.out.println("2-View supplier by id");
			System.out.println("3-Delete supplier");
			System.out.println("4-Exit");
			System.out.println("------------------------------------------------------");
			System.out.println("Enter your choice:");
			
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:System.out.println("------------------------------------------------------");
				  sd.viewAllSupplier();
				  break;
			case 2:
				System.out.println("Enter supplier id:");
				 sid=sc.nextInt();
				 sd.viewSupplierById(sid);
				 break;
			case 3:
				System.out.println("Enter supplier id:");
				sid=sc.nextInt();
				sd.deleteSupplier(sid);
				break;
				
			case 4:
				System.out.println("System closing.............");
				System.exit(0);
			default:
				System.out.println("------------------------------------------------------");
				System.out.println("Wrong input !");
			}
			System.out.println("-------------------------------------------");
			System.out.println("Do you want to continue(Enter Y-Yes/N-No).......");
			ch=sc.next().charAt(0);
		}while(ch=='y'||ch=='Y'||ch=='n'||ch=='N');
		
	}
	
	public void admincustomer()
	{
		int choice;
		char ch;
		int cid;
		do {
			System.out.println("------------------------------------------------------");
		System.out.println("1-View all customer");
		System.out.println("2-View customer by id");
		System.out.println("3-Delete customer");
		System.out.println("4-Exit");
		System.out.println("------------------------------------------------------");
		System.out.println("Enter yout choice :");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:System.out.println("------------------------------------------------------");
			cd.viewAllCustomer();
			break;
		case 2:
			System.out.println("------------------------------------------------------");
			System.out.println("Enter the customer id:");
			cid=sc.nextInt();
			System.out.println("------------------------------------------------------");
			cd.viewCustomerById(cid);
			break;
		case 3:
			System.out.println("------------------------------------------------------");
			System.out.println("Enter the customer that you want deleted:");
			cid=sc.nextInt();
			System.out.println("------------------------------------------------------");
			cd.deleteCustomer(cid);
			break;
		case 4:
		System.out.println("System closing.............");
		System.exit(0);
		default:System.out.println("------------------------------------------------------");
			System.out.println("Wrong input !");
		}
		
		System.out.println("-------------------------------------------");
		System.out.println("Do you want to continue(Enter Y-Yes/N-No).......");
		ch=sc.next().charAt(0);
	}while(ch=='y'||ch=='Y'||ch=='n'||ch=='N');	
	}
	
	public void adminorderdetails()
	{
		int choice;
		char ch;
		int oid;
		
			do {
				System.out.println("------------------------------------------------------");
				System.out.println("1-View all orders");
				System.out.println("2-View orders by customer id");
				System.out.println("3-View orders by supplier id");
				System.out.println("4-View order by order id");
				System.out.println("5-Delete order");
				System.out.println("6-Exit");
				System.out.println("------------------------------------------------------");
				System.out.println("Enter yout choice :");
				choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:System.out.println("------------------------------------------------------");
					od.viewAllOrder();
					break;
				case 2:System.out.println("------------------------------------------------------");
					System.out.println("Enter the customer id :");
					int cid=sc.nextInt();
					System.out.println("------------------------------------------------------");
					od.viewOrderByCustomerId(cid);
					break;
				case 3:System.out.println("------------------------------------------------------");
					System.out.println("Enter the supplier id:");
					int sid=sc.nextInt();
					od.viewOrderBySupId(sid);
					break;
				case 4:System.out.println("------------------------------------------------------");
					System.out.println("Enter the  order id:");
					 oid=sc.nextInt();
					 System.out.println("------------------------------------------------------");
					 od.viewOrderById(oid);
					 break;
				case 5:System.out.println("------------------------------------------------------");
					System.out.println("Enter the order id that you want to deleted:");
					 oid=sc.nextInt();
					 System.out.println("------------------------------------------------------");
					od.deleteOrder(oid);
					break;
				case 6:System.out.println("------------------------------------------------------");
					System.out.println("System closing.............");
					System.exit(0);
					
				default:
					System.out.println("------------------------------------------------------");
					System.out.println("Wrong input !");
					
				}
				System.out.println("-------------------------------------------");
				System.out.println("Do you want to continue(Enter Y-Yes/N-No).......");
				ch=sc.next().charAt(0);
			}while(ch=='y'||ch=='Y'||ch=='n'||ch=='N');
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		Adminapp ap=new Adminapp();
		System.out.println("------------------------------------------------------");
		int choice;
		char ch;
		do {
			System.out.println("--------------------- Admin Page ---------------------");
			System.out.println("1-Supplier Details");
			System.out.println("2-Customer Details");
			System.out.println("3-Order Details ");
			System.out.println("------------------------------------------------------");
			System.out.println("Enter your choice :");
			
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
		           ap.adminsupplier();
		           break;
			case 2:
				  ap.admincustomer();
				  break;
			case 3:
				  ap.adminorderdetails();
				  break;
			default:System.out.println("------------------------------------------------------");
				System.out.println("Wrong input !");
			}	
			    System.out.println("-------------------------------------------");
				System.out.println("Do you want to continue(Enter Y-Yes/N-No).......");
				ch=sc.next().charAt(0);
			}while(ch=='y'||ch=='Y'||ch=='n'||ch=='N');
	}

}
