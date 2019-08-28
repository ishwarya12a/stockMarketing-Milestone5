package com.example.stockspring.controller;

import java.sql.SQLException;

import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.User;

public interface UserController {
	
	public User insertUser(User user)throws SQLException;
	public ModelAndView getUserList()throws Exception;
	
}
