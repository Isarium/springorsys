package com.formation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Dire à Spring que cette classe sait recevoir des requêtes http
//et y répondre
@Controller
public class MonPremierControlleurSpring {

	
	@GetMapping("/") // si on tape la racine du site
	//avec la méthode GET, le contenu de la méthode sera exécuté
	@ResponseBody // On va directement écrire ce que retourne la méthode
	// sur la réponse 
	// Par défaut, si on ne met pas @responseBody, Spring pense qu'il doit utiliser
	// un moteur de vue avant d'envoyer la réponse
	public String index() {
		return "Ici mon premier controlleur Spring !";
	}
}