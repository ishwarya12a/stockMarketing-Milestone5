package com.example.stockspring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.User;
import com.example.stockspring.model.Company;
import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.CompanyServiceImpl;

@Controller
public class CompanyControllerImpl {

	
	@Autowired
	private CompanyService companyService;
	
	
	@RequestMapping(path="/companyList")
	public ModelAndView getCompanyList() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("companyList");
		mv.addObject("companyList",companyService.getCompanyList());
		return mv;
	}
	
	@RequestMapping(value = "/addcompany", method = RequestMethod.GET)
	public String getEmployeeForm(ModelMap model) {
		Company company=new Company();
		model.addAttribute("company1", company);
		return "insertCompany";
		
	}
	
	@RequestMapping(value = "/addcompany", method = RequestMethod.POST)
	public String formHandler(@Valid @ModelAttribute("company1")Company company,BindingResult result, Model model) throws SQLException{
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
			model.addAttribute("company1", company);
			return "insertCompany";
		}
		companyService.insertCompany(company);
		 return "redirect:/companyList";
	}
	
	
	// update company details
	@RequestMapping(value="/updatecompany",method=RequestMethod.GET)
	public ModelAndView updateCompany(@RequestParam("id")int companyId,ModelMap map,HttpServletRequest request ,@ModelAttribute("update")
	Company company,HttpSession session)throws SQLException,ClassNotFoundException{
		ModelAndView model=null;
		company=companyService.getCompanyCode(companyId);
		map.addAttribute("updatecompany",company);
		model=new ModelAndView("updateCompany");
		return model;
		}
	
	
	@RequestMapping(value="/updatecompany",method=RequestMethod.POST)
	public String formHandler(ModelMap map,HttpServletRequest request,@ModelAttribute("update")Company company,HttpSession session)throws SQLException{
		companyService.updateCompany(company);
		return "redirect:/companyList";
		
	}
	
	//Delete company
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteCompany(@RequestParam("id")int companyId,HttpServletRequest request,Company company,HttpSession session)throws SQLException{
		companyService.deleteCompany(companyId);
		return "redirect:/companyList";
		
	}
	
	
}
