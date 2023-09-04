package com.formation.domain;

public class Voiture {

	private Moteur moteur;

	private Roue roue;

	/**
	 * Constructeur utilisé comme point d'injection
	 * 
	 * @param moteur
	 */
	public Voiture(Moteur moteur) {
		this.moteur = moteur;
	}

	/**
	 * Setter pour roue, servira de point d'injection de dépendances
	 * 
	 * @param roue
	 */
	public void setRoue(Roue roue) {
		this.roue = roue;
	}

	public void bouger() {
		moteur.rouler();
		roue.marqueRoue();
	}

}
