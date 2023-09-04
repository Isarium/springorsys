package com.formation;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Enum implémentant le design pattern Singleton
 */
public enum Application {

	INSTANCE;

	private DataSource dataSource;

	public DataSource datasource() {

		//Si la datasource n'est pas encore créée, le créer simplement
		if (dataSource == null) {
			MysqlDataSource newDatasource = new MysqlDataSource();

			newDatasource.setUrl("url de la base");
			newDatasource.setPort(7777);
			newDatasource.setUser("root");
			newDatasource.setPassword("pwd");
			
			this.dataSource = newDatasource;
		}
		return dataSource;
	}

}
