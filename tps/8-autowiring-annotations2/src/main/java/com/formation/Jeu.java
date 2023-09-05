package com.formation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component("mon_jeu")
public class Jeu {
	
	//@Resource(name = "mon_joueur")
	@Autowired
	private Joueur joueur;

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	@Override
	public String toString() {
		return "Jeu [joueur=" + joueur + "]";
	}

}
