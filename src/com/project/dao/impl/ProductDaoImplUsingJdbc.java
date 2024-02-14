package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.projec.dao.ProductDao;
import com.project.dto.ProductDTO;
import com.project.utility.DbConnection;

public class ProductDaoImplUsingJdbc implements ProductDao{
	
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	
	@Override
	public boolean saveProduct(ProductDTO product) {
		try {
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("Insert Into product(Product_name,Product_Price, Product_category) Values(?,?,?)");
			
			pstmt.setString(1, product.getProductName());
			pstmt.setDouble(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductctgId());
			
			int rows=pstmt.executeUpdate();
			if(rows>0) {
				return true;
				
			}

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstmt!=null) {
						
					}
					if(con!=null) {
					pstmt.close();
					con.close();
					}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
	}
		return false;
		
	}
	@Override
	public boolean updateProduct(ProductDTO product) {
		try {
			con=DbConnection.getConnection();
			pstmt=con.prepareStatement("Update Product Set Product_name, Product_Price, Product_category, Product_Id) values(?,?,?,?");
			
			pstmt.setString(1, product.getProductName());
			pstmt.setDouble(2, product.getProductPrice());
			pstmt.setInt(3, product.getProductctgId());
			pstmt.setInt(4, product.getProductId());
			
			int rows=pstmt.executeUpdate();
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
			public boolean deleteProduct(ProductDTO product) {
				try {
					
					con=DbConnection.getConnection();
					pstmt=con.prepareStatement("Delete from product  Product_Name)values(?)");
					
					pstmt.setString(1, product.getProductName());
					int rows=pstmt.executeUpdate();
					if(rows>0) {
						return true;
						
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					
				}finally {
					try {
						if(pstmt!=null) {
							if(con!=null) {
								pstmt.close();
								}
							con.close();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				return false;
			}
			@Override
			public ProductDTO searchProduct(String productName) {
				ProductDTO product=null;
				try {
					con =DbConnection.getConnection();
					pstmt=con.prepareStatement("Select from product Product_name) values(?)");
					
					
					pstmt.setString(1, productName);
					ResultSet rs=pstmt.executeQuery();
					
					while(rs.next()){
						int productId=rs.getInt("Product_Id");
						String productName1=rs.getString("Product_Name");
						double productPrice=rs.getDouble("Product_Price");
						int productCtg=rs.getInt("Product_Category");
						
						
						product= new ProductDTO();
						product.setProductId(productId);
						product.setProductName(productName1);
						product.setProductPrice(productPrice);
						product.setProductctgId(productCtg);
						
					}
				}catch(Exception e) {
					e.printStackTrace();
					
				}
				return product;
				
			}
			@Override
			public List<ProductDTO> showAllProduct(){
				List<ProductDTO> product=new ArrayList<>();
				try {
					con=DbConnection.getConnection();
					stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("Select * from product");
					
					while(rs.next()) {
						int productId=rs.getInt("product_Id");
						String productName=rs.getString("Product_Name");
						double productPrice=rs.getDouble("Product_Price");
						int productCategory=rs.getInt("Product_Category");
						ProductDTO product1=new ProductDTO(productId, productName, productPrice, productCategory);
						product.add(product1);
						
						
					}

					}catch(Exception e) {
						e.printStackTrace();
					}
				return product;
				
				
			
	}
	

}
	
