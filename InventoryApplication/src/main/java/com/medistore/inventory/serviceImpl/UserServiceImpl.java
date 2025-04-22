package com.medistore.inventory.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.medistore.inventory.model.User;
import com.medistore.inventory.repository.UserRepository;
import com.medistore.inventory.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
    public String register(User user) {
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists!";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return "User registered successfully!";
    }

	@Override
    public User login(String email, String rawPassword) {
        return repo.findByEmail(email)
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
                .orElse(null);
    }

}
