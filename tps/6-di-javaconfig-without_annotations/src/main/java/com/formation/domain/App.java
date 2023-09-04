package com.formation.domain;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
	
	public static void main(String args[]) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Voiture bean = (Voiture) context.getBean("ma_voiture");
		bean.bouger();
		context.close();
	}

}
