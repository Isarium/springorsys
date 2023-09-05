package com.formation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AppMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		Jeu bean = (Jeu) context.getBean("mon_jeu");
		System.out.println(bean);
		context.close();


	}

}
