package com.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.dao.OrderDao;
import com.dao.ProductDao;
import com.dao.SupplierDao;
import com.daoimpli.OrderDaoimpl;
import com.daoimpli.ProductDaoImpl;
import com.daoimpli.SupplierDaoImpl;
import com.entity.Product;
import com.entity.Supplier;

public class SupplierApp {

	static Scanner sc=new Scanner(System.in);
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	ProductDao pd=new ProductDaoImpl();
	SupplierDao sd=new SupplierDaoImpl();
	OrderDao od=new OrderDaoimpl();
	Product p;
	Supplier s;
	
	public void registration() throws IOException
	{
		s=new Supplier();
//		System.out.println("Enter id");
//		int id=sc.nextInt();
//		s.setSid(id);
		
	   System.out.println("Enter the name :");
	   String sname=br.readLine();
	   s.setSname(sname);
	    
	   System.out.println("Enter address :");
	   String address=br.readLine();
	   s.setAddress(address);
	   
	   System.out.println("Enter the E-mail");
	   String email=sc.next();
	   s.setEmail(email);
	   
	   System.out.println("Enter the mobile Number :");
	   long number=sc.nextLong();
	   s.setPhonoNo(number);
	   
	   sd.addSupplier(s);
	   System.out.println();
	}
	
	public  void supplieraction(int sid) throws IOException
	{
		int num;
		char ch;
		do {
			System.out.println("1-Add Product");
			System.out.println("2-View All Products");
			System.out.println("3-Delete Product");
			System.out.println("4-Update Product cost");
			System.out.println("5-Change Order Status ");
			System.out.println("6-Exit");
			System.out.println("Enter your choice:");
			
			num=sc.nextInt();
			
			
			switch(num)
			{
			case 1:
				System.out.println("--------------------------------------------");
				 p=new Product();
				 System.out.println("Enter the product name :");
				 String pname=br.readLine();
				 p.setPname(pname);
				 
				 System.out.println("Enter the price of product : ");
				 int price=sc.nextInt();
				 p.setPrice(price);
				 
				 p.setSid(sid);
				 
				 
				 System.out.println("Confirm details(y-yes/n-no)");
				 char details=sc.next().charAt(0);
				 if(details=='y'||details=='Y')
				 {
					 pd.addProduct(p);
				 }
				 else
				 break;
			case 2:
				System.out.println("--------------------------------------------");
				pd.viewProductBySupId(sid);
				System.out.println("--------------------------------------------");
				break;
				 
			case 3:
				System.out.println("--------------------------------------------");
				pd.viewProductBySupId(sid);
				System.out.println("--------------------------------------------");
				System.out.println("Enter the product id you want to delete :");
				int id=sc.nextInt();
				pd.deleteProductById(id, sid);
				System.out.println("--------------------------------------------");
				break;
			
			case 4:
				System.out.println("--------------------------------------------");
				System.out.println("Enter the product id that cost you want to update:");
				int pid=sc.nextInt();
				
				pd.updateProductCost(pid);
				System.out.println("--------------------------------------------");
				break;
				
			case 5:
				System.out.println("Enter the product id that status you want to update:");
				int pid1=sc.nextInt();
				od.changeOrderStatus(pid1);
			case 6:
				System.out.println("--------------------------------------------");
				System.out.println("Closing system !");
				System.exit(0);
				System.out.println("--------------------------------------------");
			}
			System.out.println("Do you want to continue(Enter Y-Yes/N-No).......");
			ch=sc.next().charAt(0);
		}while(ch=='y'||ch=='Y'||ch=='n'||ch=='N');
	}
	
	
	public void  viewAllSupplier() {
		
		sd.viewAllSupplier();
	}
	
	public void viewSupplierById(int sid) {
		sd.viewSupplierById(sid);
	}
	public static void main(String[] args) {
		
		SupplierApp sp=new SupplierApp();
		System.out.println();
		int num;
		char ch;
		do {
			System.out.println("X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X");
			System.out.println();
			System.out.println("1-Register for new supplier");
			System.out.println("2-Login");
			System.out.println("3-Exit");
			System.out.println("Enter your choice: ");
			
			
			num=sc.nextInt();
			int sid;
			
			switch (num)
			{
			case 1:
				System.out.println("--------------------------------------------");
				try {
					sp.registration();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("--------------------------------------------");
				break;
			case 2:
				System.out.println("--------------------------------------------");
				System.out.println("Enter the Supplier Id: ");
				 sid=sc.nextInt();
			
				//Add check Supplier in the supplier dao ;boolean y
				 
				 try {
					sp.supplieraction(sid);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 System.out.println("--------------------------------------------");
				 break;
											
			case 3:System.out.println("------------- Closing system ------------");
				System.exit(0);
				
			default : System.out.println("Wrong Input !");
			}
			System.out.println("Do you want to continue(Enter Y-Yes/N-No).......");
			ch=sc.next().charAt(0);
		}while(ch=='y'||ch=='Y'||ch=='n'||ch=='N');
	}
}

