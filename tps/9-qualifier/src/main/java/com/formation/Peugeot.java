package com.formation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("peugeot")
@Primary
public class Peugeot implements Voiture{

	@Override
	public String marqueVoiture() {
		return "je suis un Peugeot !";
	}

}
