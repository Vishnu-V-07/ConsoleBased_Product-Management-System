package com.fpt.nhatnk.pms.console;
import java.util.*;

import com.fpt.nhatnk.pms.ProductEntity.Product;
import com.fpt.nhatnk.pms.controller.ProductManager;
public class ProductConsole {
	private Scanner sc;
	private ProductManager pm;
	
	public ProductConsole()
	{
		this.sc=new Scanner(System.in);
		this.pm=new ProductManager();
	}

	private int menu()
	{
		System.out.println("***PRODUCT MENU***");
		System.out.println("1. Add Product");
		System.out.println("2. Show all products");
		System.out.println("3. Remove product");
		System.out.println("0. Exit");
		int choice=readInt(0,3);
		return choice;
	}
	private int readInt(int min,int max) {
		int choice;
		while(true)
		{
			try {
			choice =Integer.parseInt(sc.nextLine());
			if(choice>=min && choice <=max)
			{
				break;
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
		return choice;
		
	}
	public void start() {
		while(true)
		{
			int choice =menu();
			switch(choice)
			{
			case 0:
				System.exit(0);
				break;
			case 1:
				addProduct();
				break;
			case 2:
				showAll();
				break;
			case 3:
				removeProduct();
				break;
			default:
				throw new AssertionError();
		}
		}
	}

	private void removeProduct() {
		System.out.println("Enter ID of product");
		int id=readInt(0,Integer.MAX_VALUE);
		boolean result=this.pm.removeProduct(id);
		if(result)
		{
			System.out.println("Product was removed");
		}
		else {
			System.out.println("Product not found");
		}
		
	}

	private void showAll() {
		System.out.println("--All Product--");
		System.out.println("ID\tName\tPrice");
		for(int i=0;i<this.pm.count();i++)
		{
			Product p=this.pm.getProduct(i);
			System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getPrice());
		}
		
	}

	private void addProduct() {
		System.out.println("Enter product ID: ");
		int id=readInt(0,Integer.MAX_VALUE);
		System.out.println("Enter product name:");
		String name=sc.nextLine();
		System.out.println("Enter product price");
		float price=readFloat(0,Float.MAX_VALUE);
		 Product p=new Product(id,name,price);
		 this.pm.addProduct(p);
	}
	private float readFloat(int min,float max) {

	    float price;
		while(true)
		{
			try {
				price=Float.parseFloat(sc.nextLine());
				if(price>=min && price <=max) {
					break;
				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid value.Try to enter a new value");
			}
			
			
		}
		return price;
	}
	   
		
		
	

	
		

	private int readInt() {
		// TODO Auto-generated method stub
		return 0;
	}
}
