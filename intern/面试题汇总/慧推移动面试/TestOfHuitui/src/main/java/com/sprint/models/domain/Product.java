package com.sprint.models.domain;

import java.util.*;
public class Product {
	private int id;
	private Date createTime;
	private Date updateTime;
	private String productName;
	private String productType;
	private double productPrice;
	private String productUnit;

	public Product() {}

	public Product(int id, String productName, String productType,
							 double productPrice, String productUnit) {
		this.id = id;
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.productUnit = productUnit;
	}
	
	public void setId(int id) {
		this.id = id;
	} 	

	public int getId() {
		return id;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	} 

	public String getProductName() {
		return productName;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductType() {
		return productType;	
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public String getProductUnit() {
		return productUnit;
	}
}
