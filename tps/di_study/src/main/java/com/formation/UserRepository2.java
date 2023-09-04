package com.formation;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class UserRepository2 {

	/// Avantages => Utilisation d'une méthode pour créer la dépendance => évite la duplication de code sur la même classe

	// limites => Que faire si on a d'autres qui ont la même dépendance sur MysqlDatasource ?
	// Pour chaque chaque méthoe qui utilise MysqlDatasource, on ouvre des sockets vers la base de données COUTEUX !

	/**
	 * Recherche un user en base de données et retourne le résultat
	 * 
	 * @param id
	 * @return
	 */
	public User findById(String id) {

		// appel de la méthode creerDatasource
		try (Connection connection = creerDatasource().getConnection()) {
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


		// appel de la méthode creerDatasource
		try (Connection connection = creerDatasource().getConnection()) {
			PreparedStatement selectStatement = connection.prepareStatement("select * from users where id =  ?");
			// recupérer user en base de données et convertir en objet User
			return new User();
		} catch (Exception e) {
			return null;
		}

	}

	public DataSource creerDatasource() {
		MysqlDataSource datasource = new MysqlDataSource();

		datasource.setUrl("url de la base");
		datasource.setPort(7777);
		datasource.setUser("root");
		datasource.setPassword("pwd");
		
		return datasource;
	}

}
