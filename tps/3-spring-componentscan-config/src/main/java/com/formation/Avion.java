package com.formation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component // Ce classe fournira un bean qui sera géré par Spring; sans préciser de nom, l'id du bean sera l'id en camelCase de la classe
public class Avion implements Vehicule{

	@Override
	public void bouger(String typeVehicule) {
		System.out.println ("je bouge en "+typeVehicule);
	}

}
