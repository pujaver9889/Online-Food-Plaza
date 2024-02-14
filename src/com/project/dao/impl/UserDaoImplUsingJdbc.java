package com.project.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.projec.dao.UserDao;
import com.project.dto.UserDTO;
import com.project.utility.DbConnection;

public class UserDaoImplUsingJdbc implements UserDao{
	private Connection con;
	private PreparedStatement ps;
	
	@Override
	public boolean saveUser(UserDTO user) {
		try {
			con = DbConnection.getConnection();
			ps = con.prepareStatement("insert into tbl_user(user_name, user_email, user_password) value(?,?,?)");
			ps.setString(1,user.getName());
			ps.setString(2,user.getEmail());
			ps.setString(3,user.getPassword());
		    int rows = ps.executeUpdate();
			if(rows>0) {
				return true;
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			
			}finally {
			try {
				if(con!=null) {
					ps.close();
					con.close();
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}
	@Override
	public boolean updateUser(UserDTO user) {
		return false;
		
	}
    @Override
    public boolean deleteUser(String email) {
    	try {
    		con = DbConnection.getConnection();
    		ps = con.prepareStatement("delete from tbl_user where email=?");
    		ps.setString(1,email);
    		int rows = ps.executeUpdate();
    		if(rows>0) {
    			return true;
    			
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		try {
    			if(con!=null) {
    				ps.close();
    				con.close();
    				
    			}
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		
    	}
    	return false;
    		
    	
    }
    @Override
    public UserDTO searchUser() {
    	return null;
    	
	}
    @Override
    public List<UserDTO> showAllUser(){
    	List<UserDTO> user = new ArrayList<>();
    	ResultSet rs=null;
    	try {
    		con = DbConnection.getConnection();
    		ps = con.prepareStatement("select * from tbl_user");
    		 rs = ps.executeQuery();
    		  while(rs.next()) {
    			  int id = rs.getInt("ID");
    			  String name = rs.getString("name");
    			  String email = rs.getString("email");
    			  String pass = rs.getString("password");
    			  UserDTO users= new UserDTO(id,name,email,pass);
    			  user.add(users);
    			  
    		  }
    		  
    			  
    		  }catch(Exception e) {
    			  
    		  
    		  }finally {
    			  try {
    				  if(con!=null) {
    					  rs.close();
    					  ps.close();
    					  con.close();
    					  
    				  }
    			  }catch(Exception e) {
    				  e.printStackTrace();
    				  
    		 }
    	}
    	return user;
    	
    }
	
		
	}
	