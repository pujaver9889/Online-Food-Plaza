package com.projec.dao;

import com.project.dto.CartDTO;

public interface CartDao {
	
	boolean isAddedtoCart(CartDTO cart);
	boolean isDeletedFromCart(CartDTO cart);

}
