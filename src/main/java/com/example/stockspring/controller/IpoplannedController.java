package com.example.stockspring.controller;

import java.sql.SQLException;

import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.Ipoplanned;


public interface IpoplannedController {
	public Ipoplanned insertIpo(Ipoplanned ipoplanned)throws SQLException;
	public ModelAndView getIpoList()throws Exception;
}
