package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import com.example.stockspring.model.User;

public interface UserService {
	 
	public User insertUser(User user)throws SQLException;
	public List<User> findByuserName(String name);
}
