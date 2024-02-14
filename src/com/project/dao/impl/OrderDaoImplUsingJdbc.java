package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.projec.dao.OrderDao;
import com.project.dto.OrderDTO;
import com.project.utility.DbConnection;

public class OrderDaoImplUsingJdbc implements OrderDao {
	private Connection con;
	private PreparedStatement pstmt;
	
	@Override
	public boolean isOrderPlaced(OrderDTO order) {
		try {
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("Insert into orders(Address, Customer_Id, Cart_Id, Total_Bill, Trancation_Type) values(?,?,?,?,?)");
			
			
			pstmt.setString(1, order.getAddress());
			pstmt.setInt(2, order.getCustomerId());
			pstmt.setInt(3, order.getCartId());
			pstmt.setDouble(4, order.getTotalBill());
			pstmt.setString(5, order.getTransactionType());
			
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				return true;
				
			}
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
		@Override
		public boolean isOrderCancelled(OrderDTO order){
			try {
				con=DbConnection.getConnection();
				pstmt=con.prepareStatement("Delete from orders where Order_Id");
				pstmt.setInt(1, order.getOrderId());
				int rows=pstmt.executeUpdate();
				
				return rows>0;
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try{
					
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
	

}
