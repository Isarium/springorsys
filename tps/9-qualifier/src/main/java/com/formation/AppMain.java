package com.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Garage bean = (Garage) context.getBean("garage");
		bean.afficherVoiture();
		context.close();
	}
	
	

}
