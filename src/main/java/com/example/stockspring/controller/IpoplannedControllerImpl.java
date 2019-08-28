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
import com.example.stockspring.service.IpoplannedService;

@Controller
public class IpoplannedControllerImpl {
	@Autowired
	private IpoplannedService ipoplannedService;
	
	@RequestMapping(value="/ipoplanned" ,method=RequestMethod.GET)
	public String getStockForm(ModelMap model) {
		Ipoplanned ipo=new Ipoplanned();
		model.addAttribute("ipo", ipo);
		return "ipoPlanned";
	}
	
	@RequestMapping(value="/ipoplanned", method=RequestMethod.POST)
	public String FormHandler(@Valid Ipoplanned ipoplanned,Model model)throws SQLException{
		ipoplannedService.insertIpo(ipoplanned);
		return "redirect:/ipoList";
		
	}
	
	@RequestMapping(value="/ipoList")
	public ModelAndView getIpoList()throws Exception{
		ModelAndView modelview=new ModelAndView();
		modelview.setViewName("ipoList");
		modelview.addObject("ipoList",ipoplannedService.getIpoList());
		return modelview;
		
	}
	
	//update ipo-planned
	@RequestMapping(value="/updateipo",method=RequestMethod.GET)
	public ModelAndView updateIpo(@RequestParam("id")int ipoId,@ModelAttribute("updateIpo")Ipoplanned ipoplanned,
		HttpServletRequest request,HttpSession session,ModelMap map)throws SQLException{
		ModelAndView model=null;
		ipoplanned=ipoplannedService.getIpoId(ipoId);
		map.addAttribute("updateipo",ipoplanned);
		model=new ModelAndView("updateIpo");
		return model;
		
	}
	
	@RequestMapping(value="/updateipo",method=RequestMethod.POST)
	public String FormHandler(@ModelAttribute("updateIpo")Ipoplanned ipoplanned,ModelMap map,HttpServletRequest request,HttpSession session)throws SQLException{
		ipoplannedService.updateIpo(ipoplanned);
		return "redirect:/ipoList";
		
	}
	
	//Delete ipoplanned
		@RequestMapping(value="/deleteipo",method=RequestMethod.GET)
		public String deleteIpo(@RequestParam("id")int ipoId,HttpServletRequest request,Ipoplanned ipoplanned,HttpSession session)throws SQLException{
			ipoplannedService.deleteIpo(ipoId);
			return "redirect:/ipoList";
			
		}
}
