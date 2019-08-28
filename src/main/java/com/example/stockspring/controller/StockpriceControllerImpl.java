package com.example.stockspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.service.StockpriceService;

@Controller
public class StockpriceControllerImpl {
	@Autowired
	private StockpriceService stockpriceService;
	
	
	@RequestMapping(path="/stockpriceList")
	public ModelAndView getStockpriceList()throws Exception{
		ModelAndView model=new ModelAndView();
		model.setViewName("stockpriceList");
		model.addObject("stockprice", stockpriceService.getStockpriceList());
		return model;
		
	}

}
