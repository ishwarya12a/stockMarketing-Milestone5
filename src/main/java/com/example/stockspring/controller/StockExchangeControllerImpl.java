package com.example.stockspring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Ipoplanned;
import com.example.stockspring.model.StockExchange;
import com.example.stockspring.service.StockExchangeService;

@Controller
public class StockExchangeControllerImpl {
	@Autowired
	private StockExchangeService stockexchangeService;
	
	@RequestMapping(value="/stockexchange" ,method=RequestMethod.GET)
	public String getStockForm(ModelMap model) {
		StockExchange stockexchange=new StockExchange();
		model.addAttribute("stock", stockexchange);
		return "stockExchange";
	}
	
	@RequestMapping(value="/stockexchange", method=RequestMethod.POST)
	public String FormHandler(@Valid @ModelAttribute("stock")StockExchange stockexchange,Model model)throws SQLException{
		stockexchangeService.insertStock(stockexchange);
		return "redirect:/stockList";
		
	}
	
	@RequestMapping(value="/stockList")
	public ModelAndView getStockList()throws Exception{
		ModelAndView modelview=new ModelAndView();
		modelview.setViewName("stockexchangeList");
		modelview.addObject("stockexchangeList",stockexchangeService.getStockList());
		return modelview;
		
	}
	
	//update stock exchange
	@RequestMapping(value="/updatestock",method=RequestMethod.GET)
	public ModelAndView updateIpo(@RequestParam("id")int stockId,@ModelAttribute("updatestock")StockExchange stockexchange,
		HttpServletRequest request,HttpSession session,ModelMap map)throws SQLException{
		ModelAndView model=null;
		stockexchange=stockexchangeService.getStockId(stockId);
		map.addAttribute("stockipo",stockexchange);
		model=new ModelAndView("updateStock");
		return model;
		
	}
	
	@RequestMapping(value="/updatestock",method=RequestMethod.POST)
	public String FormHandler(@ModelAttribute("updatestock")StockExchange stockexchange,ModelMap map,HttpServletRequest request,HttpSession session)throws SQLException{
		stockexchangeService.updateStock(stockexchange);
		return "redirect:/stockList";
		
	}
	
	//Delete stock
			@RequestMapping(value="/deletestock",method=RequestMethod.GET)
			public String deleteIpo(@RequestParam("id")int stockId,HttpServletRequest request,StockExchange stockexchange,HttpSession session)throws SQLException{
				stockexchangeService.deleteStock(stockId);
				return "redirect:/stockList";
				
			}
}
