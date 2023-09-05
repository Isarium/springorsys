
package com.formation;

import org.springframework.stereotype.Component;

@Component("mon_joueur")
public class Joueur {
	
	private String nom = "Mario2";

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + "]";
	}
	
	
}
