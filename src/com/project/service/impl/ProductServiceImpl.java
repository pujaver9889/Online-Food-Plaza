package com.project.service.impl;
import java.util.List;

import com.projec.dao.ProductDao;
import com.project.dao.impl.ProductDaoImplUsingJdbc;
import com.project.dto.ProductDTO;
import com.project.service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	private ProductDao productDao= new ProductDaoImplUsingJdbc();
		
		@Override
		public boolean saveProduct(ProductDTO product) {
			return productDao.saveProduct(product);
			
		}
		@Override
		public boolean updateProduct(ProductDTO product) {
			return productDao.updateProduct(product);
			
		}
		@Override
		public boolean deleteProduct(ProductDTO product) {
			return productDao.deleteProduct(product);
			
		}
		@Override
		public ProductDTO searchProduct(String productName) {
			// TODO Auto-generated method stub
			return productDao.searchProduct(productName);
		}
		@Override
		public List<ProductDTO> showAllProduct() {
			// TODO Auto-generated method stub
			return productDao.showAllProduct();
		}
		
	}
	
	


