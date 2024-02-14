package com.project.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.project.dto.CartDTO;
import com.project.service.CartService;
import com.project.service.impl.CartServiceImpl;


public class CartController {
	
	private int optionCart=0;
	Scanner s=new Scanner(System.in);
	CartService cartService=new CartServiceImpl();
	{
		
		do {
			
			System.out.println("1. Select 1 Add to cart\n2. Delete from Cart \n3. Select 3 for exit");
			optionCart=s.nextInt();
			switch(optionCart) {
			case 1:
				addCart();
				break;
			case 2:
				isDeleteFromCart();
				break;
			case 3:
				System.out.println("Exited from cart section successfully...");
				break;
				
					
			}
		}while(optionCart!=3);
		
	}
	private  void addCart() {
		InputStreamReader isr=null;
		BufferedReader br=null;
		
		try {
			isr = new InputStreamReader(System.in);
			br=new BufferedReader(isr);
			System.out.println("Enter customer id:");
			int customerId=s.nextInt();
			System.out.println("Enter product Id:");
			int productId=s.nextInt();
			System.out.println("Enter quantity:");
			int productQuantity =s.nextInt();
			System.out.println(productQuantity);
			System.out.println("Enter total price:");
			double totalPrice=s.nextDouble();
			System.out.println("Enter payment status: cash/ card");
			String paymentStatus= br.readLine();
			CartDTO cart= new CartDTO(customerId, productId, productQuantity, totalPrice, paymentStatus);
			//System.out.println("cart= "+cart);
			boolean isAddedCart= cartService.isAddedToCart(cart);
			
			
			if(isAddedCart) {
				System.out.println("Product added to cart successfully.");
				
			}
			else {
				System.out.println("Failed to add to cart.");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	private void isDeleteFromCart() {
		try {
			System.out.println("Enter product id:");
			int productId=s.nextInt();
			CartDTO cart=new CartDTO(productId);
			
			boolean isDeletedFormate= cartService.isDeletedFromCart(cart);
			
			if(isDeletedFormate) {
				System.out.println("Item removed from cart successfully.");
				
			}
			else {
				System.out.println("Failed to remove item from cart,");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

  } 


