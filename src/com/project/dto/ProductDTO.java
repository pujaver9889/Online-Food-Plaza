package com.project.dto;

public class ProductDTO {
	private Integer productId;
	private String productName;
	private Double productPrice;
	private Integer productctgId;
		
	public ProductDTO() {
		
	}
	

	public ProductDTO(String productName) {
		super();
		this.productName = productName;
	}


	public ProductDTO(Integer productId, String productName, Double productPrice, Integer productctgId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productctgId = productctgId;
	}


	public ProductDTO(String productName, Double productPrice, Integer productctgId) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productctgId = productctgId;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}


	public Integer getProductctgId() {
		return productctgId;
	}


	public void setProductctgId(Integer productctgId) {
		this.productctgId = productctgId;
	}


	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productctgId=" + productctgId + "]";
	}

	
	

}
