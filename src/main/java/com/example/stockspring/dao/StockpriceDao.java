package com.example.stockspring.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.stockspring.model.Stockprice;

public interface StockpriceDao extends JpaRepository<Stockprice,Integer> {
	public List<Stockprice> findByCompanyCode(@Param("companyCode")int companyCode);
    @Query("select s.price from Stockprice s where s.companyCode=:companyCode and s.date between :fromdate and :todate")
    public List<Double> findBycompanyCode(@Param(value="companyCode") int companyCode,@Param(value = "fromdate") Date fromdate, @Param(value = "todate") Date todate);


	 
}
