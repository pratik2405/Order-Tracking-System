package com.app;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dao.CustomerDao;
import com.dao.OrderDao;
import com.dao.ProductDao;
import com.daoimpli.CustomerImpli;
import com.daoimpli.OrderDaoimpl;
import com.daoimpli.ProductDaoImpl;
import com.entity.Customer;
import com.entity.OrderDetails;
import com.entity.Product;

public class CustomerApp {
	
	static Scanner sc=new Scanner(System.in);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    CustomerDao cd=new CustomerImpli();
    ProductDao pd=new ProductDaoImpl();
    OrderDao od=new OrderDaoimpl();
    Customer c;
    Product p;
    OrderDetails o;
	
	public void custregistration() throws IOException
	{
		c=new Customer();
		
		System.out.println("Enter Your Name :");
		String cname=br.readLine();
		c.setCname(cname);
		
		System.out.println("Enter Your Phone Number : ");
		long phonono=sc.nextLong();
		c.setPhonoNo(phonono);
		
		System.out.println("Enter Your Address : ");
		String address=br.readLine();
		c.setAddress(address);
		
		System.out.println("Confirm details(y-yes/n-no)");
		char details=sc.next().charAt(0);
		if(details=='y'||details=='Y')
		{
		cd.addcustomer(c);
		}
		
	}
	
	public void login(int cid)
	{
		int num;
		char ch;
		do {
			System.out.println("------------------------------------------------------");
		    System.out.println("1-View products");
		    System.out.println("2-Buy product");
		    System.out.println("3-View orders");
		    System.out.println("4-Delete order");
		    System.out.println("5-Exit");
		    System.out.println("------------------------------------------------------");
		    System.out.println("Enter your choice :");
		    num=sc.nextInt();
		    
		    switch(num)
		    {
		    case 1:System.out.println("------------------------------------------------------");
		    	 pd.viewAllProduct();
		    	 break;
		    case 2:
		    	System.out.println("------------------------------------------------------");
		    	o=new OrderDetails();
		    	o.setCid(cid);
		    	
		    	System.out.println("Enter the product id you want to buy :");
		    	int pid=sc.nextInt();
		    	o.setPid(pid);
		    	
		    	//od.addOrder(o);
		    	System.out.println("confirm your order(y-yes/n-no)");
		    	char buy=sc.next().charAt(0);
		    	if(buy=='y')
		    	{
		    		od.addOrder(o);
		    	}
		    	else
		    	 break;
		    case 3:
		    	System.out.println("------------------------------------------------------");
		    	od.viewOrderByCustomerId(cid);
		    	break;
		    case 4:
		    	System.out.println("------------------------------------------------------");
		    	System.out.println("Enter the order id that you want to delete :");
		    	int orderid=sc.nextInt();
		    	System.out.println("------------------------------------------------------");
		        od.deleteorderbyid(orderid, cid);
		    	break;
		    case 5:
		    	System.out.println("System closing........");
		    	System.exit(0);
		    }
		    System.out.println("--------------------------------------------------------");
		    System.out.println("Do you want to continue(Y-Yes/N-No).......");
			ch=sc.next().charAt(0);
		}while(ch=='y'||ch=='Y'||ch=='n'||ch=='N');
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

       CustomerApp ca=new CustomerApp();		
       int num;
		char ch;
		do {
			System.out.println("--------------------------------------------------------");
			System.out.println("1- Registration for new customer");
			System.out.println("2- Login");
			System.out.println("3- Exit");
			System.out.println("------------------------------------------------------");
			System.out.println("Enter your choice :");
			 num=sc.nextInt();
			
			switch(num)
			{
			case 1:
				System.out.println("--------------------------------------------------------");
				try {
					ca.custregistration();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("--------------------------------------------------------");
				break;
			case 2:
				System.out.println("--------------------------------------------------------");
				System.out.println("Enter your customer id :");
				int cid=sc.nextInt();
				ca.login(cid);
				System.out.println("--------------------------------------------------------");
				break;
			case 3:
				System.out.println("-------- Closing System ----------");
				System.exit(0);
				System.out.println("--------------------------------------------------------");
				break;
			}
			System.out.println("--------------------------------------------------------");
			System.out.println("Do you want to continue..(y-yes/n-no)");
			ch=sc.next().charAt(0);
            
		}while(ch=='y'||ch=='n'||ch=='Y'||ch=='N');
	}

}
