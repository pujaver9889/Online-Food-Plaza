package com.project.service.impl;

import com.projec.dao.CartDao;
import com.project.dao.impl.CartDaoImplUsingJdbc;
import com.project.dto.CartDTO;
import com.project.service.CartService;

public class CartServiceImpl implements CartService {
	CartDao cartDao = new CartDaoImplUsingJdbc();

	@Override
	public boolean isAddedToCart(CartDTO cart) {
		//System.out.println(cart);
		return cartDao.isAddedtoCart(cart);
	}

	@Override
	public boolean isDeletedFromCart(CartDTO cart) {
		// TODO Auto-generated method stub
		return cartDao.isDeletedFromCart(cart) ;
	}

	

}
