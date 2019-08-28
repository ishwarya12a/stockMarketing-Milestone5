package com.example.stockspring.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ipo_planned")
public class Ipoplanned {
	@Id
	@Column(name="id")
	private int ipoId;
	@Column(name="Company_code")
	private int companyCode;
	@Column(name="stock_exchange")
	private int stockExchange;
	@Column(name="price_per_share")
	private float price;
	@Column(name="total_no_of_shares")
	private int totalshare;
	@Column(name="open_date_time")
	private Date date;
	@Column(name="remarks")
	private String remarks;
	
	public int getIpoId() {
		return ipoId;
	}
	public void setIpoId(int ipoId) {
		this.ipoId = ipoId;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public int getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(int stockExchange) {
		this.stockExchange = stockExchange;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getTotalshare() {
		return totalshare;
	}
	public void setTotalshare(int totalshare) {
		this.totalshare = totalshare;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}

