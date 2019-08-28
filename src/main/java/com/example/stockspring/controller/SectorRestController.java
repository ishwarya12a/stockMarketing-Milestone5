package com.example.stockspring.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockspring.dao.CompanyDao;
import com.example.stockspring.dao.IpoplannedDao;
import com.example.stockspring.dao.StockpriceDao;
import com.example.stockspring.model.*;

@RestController
public class SectorRestController {
	@Autowired
	CompanyDao companydao;
	@Autowired 
	IpoplannedDao ipoplannedDao;
	@Autowired
	StockpriceDao stockpriceDao;
	@GetMapping("/sector/{sectorId}")
	public List<Company> SectorList(@PathVariable("sectorId")int sectorId)
	{
		return companydao.findBysectorId(sectorId);
	}
	
	@GetMapping("/ipoplanned/{code}")
	public List<Ipoplanned> IpoList(@PathVariable("code")int companyCode){
		return ipoplannedDao.findBycompanyCode(companyCode);
	}
	
	@GetMapping("/stockprice/{companyCode}")
	public List<Stockprice> StockpriceList(@PathVariable("companyCode")int companyCode){
		return stockpriceDao.findByCompanyCode(companyCode);
	}
	
	@GetMapping("/company/{companyName}")
	public List<Company> companyList(@PathVariable("companyName")String companyName){
		return companydao.findBycompanyName(companyName);
	}
	
	
	@GetMapping("/listofcompaniesinsector/{sectorId}/{fromdate}/{todate}")
    Double companySectorList(@PathVariable("sectorId") int sectorId,@PathVariable("fromdate") Date fromdate,@PathVariable("todate") Date todate)
    {
           Double sum=0.0;
           int companyCode[]= companydao.findSectorList(sectorId);
           List<Double> stockPriceList=new ArrayList<>();
           for(int i=0;i<companyCode.length;i++)
           {
              System.out.println(companyCode[i]);
                  stockpriceDao.findBycompanyCode(companyCode[i],fromdate,todate).forEach(stockPriceList::add);;
           }
           
           for(Double price:stockPriceList)
           {
               sum=sum+price;
           }
           return sum;
    }
      



   

}
