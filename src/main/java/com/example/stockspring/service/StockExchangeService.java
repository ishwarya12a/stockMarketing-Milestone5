package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import com.example.stockspring.model.StockExchange;

public interface StockExchangeService {
	public StockExchange insertStock(StockExchange stockExchange)throws SQLException;
	public StockExchange getStockId(int stockId)throws SQLException;
	public StockExchange updateStock(StockExchange stockexchange)throws SQLException;
	public List<StockExchange> getStockList()throws SQLException;
	public void deleteStock(int stockId)throws SQLException;
}
