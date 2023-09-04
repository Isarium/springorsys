package com.formation.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	// bean roue
	@Bean("roue")
	public Roue beanRoue() {
		return new RouePirelli();
	}
	
	// bean moteur
	@Bean("moteur")
	public Moteur beanMoteur() {
		return new MoteurDiesel();
	}
	
	//bean voiture
	@Bean("ma_voiture")
	public Voiture beanVoiture() {
		// injection de la dépendance moteur via constructor
		Voiture voiture = new Voiture(beanMoteur());
		// injection de la dépendance roue via setter
		voiture.setRoue(beanRoue());
		return voiture;
	}

}