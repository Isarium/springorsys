package com.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// Recuperation du contexte sur la classe annotée avec @Configuration
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// Récuperation d'un bean
		Avion bean = (Avion) context.getBean("avion");
		bean.bouger("avion");
		

	}

}
