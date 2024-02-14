package com.project.dto;

public class OrderDTO {
	private Integer orderId;
	private Integer customerId;
	private Integer cartId;
	private String address;
	private double TotalBill;
	private String transactionType;
	
	
	public OrderDTO() {
		
		
	}


	public OrderDTO(Integer orderId, Integer customerId, Integer cartId, String address, double totalBill,
			String transactionType) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.cartId = cartId;
		this.address = address;
		TotalBill = totalBill;
		this.transactionType = transactionType;
	}

    public OrderDTO(Integer orderId) {
    	super();
    	this.setOrderId(orderId);

	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public Integer getCartId() {
		return cartId;
	}


	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getTotalBill() {
		return TotalBill;
	}


	public void setTotalBill(double totalBill) {
		TotalBill = totalBill;
	}


	public String getTransactionType() {
		return transactionType;
	}


	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
	
	
	
	
	

}
