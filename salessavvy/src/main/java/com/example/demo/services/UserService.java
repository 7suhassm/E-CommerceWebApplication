package com.example.demo.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
// connecting to repository and using password encoder
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		passwordEncoder = new BCryptPasswordEncoder();
	}

	public User userRegister(User user) {
// to check id user name exits in database
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
			// throws
			throw new RuntimeException("Username is already taken");
		}
//		to check if email exist in data base
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
			throw new RuntimeException("Email already registerd");
		}
//		for better efficiency
// encoding password for security purpose
		user.setPassword(passwordEncoder.encode(user.getPassword()));

//		String ppwd = user.getPassword();
//		String epwd=passwordEncoder.encode(ppwd);
//		user.setPassword(epwd);
        return userRepository.save(user);
	}
}
