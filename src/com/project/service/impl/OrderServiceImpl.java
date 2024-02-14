package com.project.service.impl;

import com.projec.dao.OrderDao;
import com.project.dao.impl.OrderDaoImplUsingJdbc;
import com.project.dto.OrderDTO;
import com.project.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	private OrderDao orderdao=new OrderDaoImplUsingJdbc();
	
	@Override
	public boolean isOrderPlaced(OrderDTO order) {
		return orderdao.isOrderPlaced(order);
		
		
	}

	@Override
	public boolean isOrderCancelled(Integer order) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
