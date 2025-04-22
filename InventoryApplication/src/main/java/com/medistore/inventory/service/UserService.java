package com.medistore.inventory.service;

import com.medistore.inventory.model.User;

public interface UserService {
	String register(User user);
	User login(String email, String Password);
}
