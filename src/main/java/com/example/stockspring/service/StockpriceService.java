package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import com.example.stockspring.model.Stockprice;

public interface StockpriceService {
	public List<Stockprice> getStockpriceList()throws SQLException;

}
