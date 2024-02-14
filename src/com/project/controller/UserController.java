package com.project.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;


public class UserController {
	
	private int optionUser=0;
	Scanner s = new Scanner(System.in);
	UserService userService = new UserServiceImpl();
	
	//start of instance block
	{
		do {
			System.out.println("1. Select 1 Add User\n2. Select 2 Delete User\n3. Select 3 Update User" +" \n4. Select 4 to Show All User\n5. Select 5 to Show Any User\n6. Select 6 for Exit");
			optionUser = s.nextInt();
			switch(optionUser) {
			case 1:
				addUser();
				break;
			case 2:
				deleteAnyUser();
				
				break;
			case 3:
				updateUser();
								break;
			case 4:
				System.out.println("Show All User...");
				
				break;
			case 5:
				searchUser();
				
				break;
			case 6:
				System.out.println("Exited from User Section Successfully...");
				break;
		   }
					
		}
		while(optionUser!=6);
		
	}//end of instance block
	
	private void addUser() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br =  new BufferedReader(isr);
			System.out.println("Enter name");
			String name=br.readLine();
			System.out.println("Enter email");
			String email=br.readLine();
			System.out.println("Enter password");
			String pass=br.readLine();
			UserDTO user=new UserDTO(name,email,pass);
			boolean isUserSaved=userService.saveUser(user);
			if(isUserSaved) {
				System.out.println("Data has been saved successfully...");
				
			}
			else {
				System.out.println("Something went wrong to save data..");
				
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void searchUser() {
		
	}
	private void updateUser() {
		
	}
	private void deleteAnyUser() {
		System.out.println("Enter your email id to delete record");
		String email = s.next();
		boolean isUserDelete = userService.deleteUser(email);
		if(isUserDelete) {
			System.out.println("Record has been deleted successfully...");
			showAllUserData();
				
			}else {
				System.out.println("Something went wrong to delete record...");
				
			}
	}
	private void showAllUserData() {
		
		List<UserDTO> users = userService.showAllUser();
		System.out.println("-----------------------------User Record are---------------");
		for(UserDTO user: users) {
			System.out.println(user);
		}
		
	}
	

}



