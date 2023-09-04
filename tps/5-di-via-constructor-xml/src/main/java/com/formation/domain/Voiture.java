package com.formation.domain;

public class Voiture {
	
	private Moteur moteur;
	
	private String constructeur;
	
	/**
	 * Constructeur utilisé comme point d'injection
	 * @param moteur
	 */
	public Voiture(Moteur moteur) {
		this.moteur = moteur;
	}
	
	/**
	 * Setter qui servira de point d'injection pour la dépendance constructeur
	 * @param construteur
	 */
	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}


	public void bouger(){
		moteur.rouler();
		System.out.println(constructeur);
	}
	
}
