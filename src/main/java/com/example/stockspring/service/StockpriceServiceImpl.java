package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockspring.dao.StockpriceDao;
import com.example.stockspring.model.Stockprice;

@Service
public class StockpriceServiceImpl implements StockpriceService {
	@Autowired
	private StockpriceDao stockpriceDao;

	@Override
	public List<Stockprice> getStockpriceList() throws SQLException {
		// TODO Auto-generated method stub
		return stockpriceDao.findAll();
	}

}
