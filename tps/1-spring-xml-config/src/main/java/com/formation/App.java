package com.formation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		//Récupération du contexte Spring
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		//Recupére un bean dans le contexte
		Avion bean = (Avion) context.getBean("avionBean");
		bean.bouger("avion");
		context.close();

	}

}
