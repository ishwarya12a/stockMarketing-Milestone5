package com.example.stockspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.stockspring.model.StockExchange;

public interface StockExchangeDao extends JpaRepository<StockExchange,Integer> {
	  
//	public Company insertCompany(Company company) throws SQLException;
//	    public Company updateCompany(Company company);
//		public List<Company> getCompanyList() throws SQLException;

}