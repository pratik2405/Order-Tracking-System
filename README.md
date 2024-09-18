# Order-Tracking-System

## Project Overview :-

The Order Tracking System is a Java-based application that leverages JDBC for database connectivity and MySQL for data management. The system is designed to handle different user roles—Admin, Supplier, and Customer—each with specific functionalities. It provides a comprehensive solution for managing orders, products, and user interactions, with features that include real-time order tracking, product management, and role-based access control.


## Features :-

**Admin :** Full access to manage customers, suppliers, products, and orders.

**Supplier :** Capable of adding and deleting products, changing order statuses, and viewing total orders.

**Customer :** Can purchase products, check order details, and view previous orders.



## Database :-

**Database Management System :**  MySQL

**Database tables :** Customer,Orderdetails,Product, Supplier. 

**Triggers Implemented :** Order Count Update : Automatically increments the total order count when a customer buys a product and decrements it upon product deletion.

## Technologies :-

**Programming Language :**  Java

**Database Connectivity :**  JDBC (Java Database Connectivity)

**Database :**  MySQL


## Usage :-

**Admin :** Log in with admin credentials to manage all aspects of the system.

**Supplier :** Log in to add or remove products, manage order statuses, and view total orders.

**Customer :** Log in to purchase products, view current and past order details.

## Database Schema :-


 
**Customer :-** Store customer information like name,phone no,address,total order.
 
**Orderdetails :-**	Store all order details like order id, customer id,product id, delivery date, order status.
 
**Product :-** Store product details like name, price,supplier id.
 
**Suplier :-** Stores supplier details.

