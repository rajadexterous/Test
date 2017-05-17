package com.cts.poc.service;


import java.util.List;

import com.cts.poc.model.User;

public interface UserService {
	
	User findById(long id);
	
	List<User> findAllUsers();

}
