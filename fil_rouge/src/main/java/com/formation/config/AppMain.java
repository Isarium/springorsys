package com.formation.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.formation.domain.Duplicata;
import com.formation.service.DuplicataService;


public class AppMain {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DuplicataService beanDuplicationService = (DuplicataService) context.getBean("duplicataService");
		
		Duplicata duplicate = beanDuplicationService.createDuplicata("ABHH55", 3000);
		System.out.println(duplicate);
		
		


	}
}
