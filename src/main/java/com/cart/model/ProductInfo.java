package com.cart.model;

public class ProductInfo{
	private String code;
	private String name;
	public ProductInfo(){}
	public ProductInfo(String name,String code,String price){
		this.code=code;
		this.price=price;
		this.name=name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private String price;
}