package com.formation;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class UserRepository4 {


	//créer un champ de type datasource
	private DataSource datasource;
	
	//Créer un setter qui servira de point d'injection de dépendances
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	
	/**
	 * Recherche un user en base de données et retourne le résultat
	 * 
	 * @param id
	 * @return
	 */
	public User findById(String id) {

		// Appel des méthodes de Datasource, sans se soucier de comment il est injecté
		try (Connection connection = datasource.getConnection()) {
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
		try (Connection connection = datasource.getConnection()) {
			PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
			// recupérer user en base de données et convertir en objet User
			return new User();
		} catch (Exception e) {
			return null;
		}

	}


}
