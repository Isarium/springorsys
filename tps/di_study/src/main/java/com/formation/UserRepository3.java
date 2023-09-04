package com.formation;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class UserRepository3 {

	/// Avantages => Instance unique de MysqlDatasource, partagée par toutes les classes
	// Les classes ne gérent plus elles-mêmes leurs dépendances : elles déléguent cela à la classe Application

	// limites => Recherche de dépendances active ! contraire au principe d'hollywood
	// La classe Application va grossir au fil du temps

	/**
	 * Recherche un user en base de données et retourne le résultat
	 * 
	 * @param id
	 * @return
	 */
	public User findById(String id) {

		// Appel du singleton pour récuperer l'instance unique de MysqlDatasource
		try (Connection connection = Application.INSTANCE.datasource().getConnection()) {
			PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
			// recupérer user en base de données et convertir en objet User
			return new User();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Recherche un user en base de données part nom et retourne le résultat
	 * 
	 * @param id
	 * @return
	 */
	public User findByName(String name) {


		// Appel du singleton pour récuperer l'instance unique de MysqlDatasource
		try (Connection connection = Application.INSTANCE.datasource().getConnection()) {
			PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
			// recupérer user en base de données et convertir en objet User
			return new User();
		} catch (Exception e) {
			return null;
		}

	}


}
