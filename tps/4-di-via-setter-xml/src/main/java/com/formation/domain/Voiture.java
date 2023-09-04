package com.formation.domain;

public class Voiture {
	
	private Moteur moteur;

	/**
	 * Setter qui servira de point d'injection
	 * @param moteur
	 */
	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}
	
	public void bouger(){
		moteur.rouler();
	}
	
}
