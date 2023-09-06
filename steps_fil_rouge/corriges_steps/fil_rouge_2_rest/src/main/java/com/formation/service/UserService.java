package com.formation.service;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.formation.domain.User;

@Component
public class UserService {
	
	public User findById(String userId) {
		
		String user_name_db = UUID.randomUUID().toString();
		User user = new User();
		user.setId(userId);
		user.setName(user_name_db);
		return user;
	}

}
