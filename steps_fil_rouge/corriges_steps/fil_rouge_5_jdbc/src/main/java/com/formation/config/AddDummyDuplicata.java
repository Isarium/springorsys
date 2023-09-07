package com.formation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.formation.service.DuplicataService;

import jakarta.annotation.PostConstruct;

@Service
@Profile("dev")
public class AddDummyDuplicata {
	
	@Autowired
	private DuplicataService duplicataService;
	
	@PostConstruct
	public void initDuplicatas() {
		duplicataService.createDuplicata("AYYY", 400);
		duplicataService.createDuplicata("JU2U", 1500);
		duplicataService.createDuplicata("AHHA", 5000);
	}
	

}
