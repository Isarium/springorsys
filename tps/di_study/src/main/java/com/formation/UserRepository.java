package com.formation;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class UserRepository {
	
	
	/// Avantages => ça marche
	
	//limites => approche naive. 
	//Que faire si on plusieurs méthodes qui utilisent la même dépendance
	
	

	/**
	 * Recherche un user en base de données et retourne le résultat
	 * 
	 * @param id
	 * @return
	 */
	public User findById(String id) {

		// Definir une datasource pour ouvrir des connexions sur la base de données
		MysqlDataSource datasource = new MysqlDataSource();
		
		datasource.setUrl("url de la base");
		datasource.setPort(7777);
		datasource.setUser("root");
		datasource.setPassword("pwd");
		
		
		//code pour requêter la base et chercher des user
		try (Connection connection = datasource.getConnection()) {
			PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
			// recupérer user en base de données et convertir en objet User
			return new User();
		} catch (Exception e) {
			return null;
		}

	}

}
