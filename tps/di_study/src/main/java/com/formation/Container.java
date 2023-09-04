package com.formation;

public class Container {
	
	public static void main(String[] args) {
		
		//instanciation de UserRepository4
		UserRepository4 userRepo = new UserRepository4();
		
		//injection de dépendance
		userRepo.setDatasource(Application.INSTANCE.datasource());
		
	}

}
