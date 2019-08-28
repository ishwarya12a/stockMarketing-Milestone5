package com.example.stockspring.controller;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.stockspring.model.User;
import com.example.stockspring.service.UserService;

@Controller
public class UserControllerImpl {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/usersignup", method= RequestMethod.GET)
	public String getUserForm(ModelMap model) {
		User user=new User();
		model.addAttribute("user",user);
		return "userSignup";
		
	}
	
	@RequestMapping(value="/usersignup", method= RequestMethod.POST)
	public String formHandler(@Valid User user,ModelMap model)throws SQLException{
		userService.insertUser(user);
		return "redirect:/login";
		
	}
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String Login(ModelMap model) {
		User user=new User();
		model.addAttribute("login",user);
		return "userLogin";
		
	}

	@RequestMapping(value= "/login", method = RequestMethod.POST)
    public ModelAndView login(@Valid @ModelAttribute("login") User user) throws Exception {
		ModelAndView model = null;
		String name = user.getUserName();
		List<User> user1 = userService.findByuserName(name);
		User user2 = user1.get(0);
		if ((user.getUserName().equals(user2.getUserName())) && (user.getPassword().equals(user2.getPassword()))) {
			if (user2.getUserType().equals("user")) {
				model = new ModelAndView("userLandingPage");
				} else {
					model = new ModelAndView("adminLandingPage");
                }
			} else {
				model = new ModelAndView("userLogin", "message", "Invalid Username or Password");
			}
		return model;

    }

}
