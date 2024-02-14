package com.projec.dao;

import java.util.List;

import com.project.dto.ProductDTO;

public interface ProductDao {
	boolean saveProduct(ProductDTO product);
	boolean updateProduct(ProductDTO product);
	boolean deleteProduct(ProductDTO product);
	ProductDTO searchProduct(String productName);
	List<ProductDTO> showAllProduct();

}
