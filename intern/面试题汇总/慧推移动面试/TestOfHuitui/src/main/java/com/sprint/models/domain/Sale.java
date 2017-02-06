package com.sprint.models.domain;

import java.util.Date;
public class Sale {
	private int userId;
	private int productId;
	private Date createTime;
	private Date updateTime;
	private String saleDate;
	private double salePrice;
	private double saleNumber;

	public Sale() {}
	public Sale(int userId, int productId, String saleDate,
									double salePrice, double saleNumber) {
		this.userId = userId;
		this.productId = productId;
		this.saleDate = saleDate;
		this.salePrice = salePrice;
		this.saleNumber = saleNumber;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	} 

	public int getUserId() {
		return userId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	} 

	public int getProductId() {
		return productId;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	} 

	public double getSalePrice() {
		return salePrice;
	}

	public void setSaleNumber(double saleNumber) {
		this.saleNumber = saleNumber;
	}

	public double getSaleNumber() {
		return saleNumber;
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
}
