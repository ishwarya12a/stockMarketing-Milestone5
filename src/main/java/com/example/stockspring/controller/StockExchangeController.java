package com.example.stockspring.controller;

import java.sql.SQLException;

import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.StockExchange;

public interface StockExchangeController {
	
	public StockExchange insertStock(StockExchange stockExchange)throws SQLException;
	public ModelAndView getStockList()throws Exception;

}
