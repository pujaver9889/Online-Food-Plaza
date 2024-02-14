package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.projec.dao.AdminDao;
import com.project.dto.AdminDTO;
import com.project.utility.DbConnection;

public class AdminDoImplUsingJdbc implements AdminDao{
	
	private Connection con;
	private PreparedStatement pstmt;
	@Override
	public boolean isAdminSave(AdminDTO admin) {
		try {
			
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("Insert into Admin(UserName, Password) values(?,?)");
			pstmt.setString(1, admin.getUsername());
			pstmt.setString(2, admin.getPassword());
			int rows=pstmt.executeUpdate();
			
			
			return rows>0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return false;
		
	}
	public boolean isAdminDeleted(String username) {
		try {
			
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("Delete form admin where username=?");
			pstmt.setString(1, username);
			int rows=pstmt.executeUpdate();
			
			return rows>0;
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
	   }finally {
		   
	   }
		return false;
	}
	

}
