package com.cart.model;

import javax.persistence.Column;

public class CategoryInfo{
	
	private String code;
	private String name;
	
	public String getCode() {
		return code;
	}
	public void setCode(String cid) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}