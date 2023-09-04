package com.formation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;


/**
 * Cette classe joue le même rôle que le fichier xml
 * 
 */
@Configuration
public class AppConfig {

	@Bean(name="avionBean")
	@Description("Ceci un bean de Avion de type Vehicule")
	public Avion nom_methode_arbitraire() {
		return new Avion();
	}
	
	@Bean("beanMoteur")
	public Moteur moteur() {
		return new Moteur();
	}

}