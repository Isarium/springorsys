package com.formation;

import org.springframework.stereotype.Component;

@Component("mercedes")
public class Mercedes implements Voiture{

	@Override
	public String marqueVoiture() {
		return "je suis une Mercedes !";
	}
}
