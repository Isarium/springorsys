package com.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Garage {
	
	@Autowired
	//@Qualifier("mercedes")
	private Voiture voiture;
	
	public void afficherVoiture() {
		System.out.println(voiture.marqueVoiture());
	}

}
