package com.formation.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.formation.web.formulaires.FormulaireConnexion;

import jakarta.validation.Valid;

@Controller
public class WebControlleur {

	@GetMapping("/")
    public String homepage(Model model, @RequestParam(required = false, defaultValue = "Individu") String prenom) {
        // model permet de préciser les élements à renvoyer à la vue
		// dans la vue, un attribut prenom un attribut dateActuelle seront disponible
		model.addAttribute("prenom", prenom);
        model.addAttribute("dateActuelle", LocalDateTime.now());
        return "index.html";
    }
	
	// méthode qui permet d'afficher le formulaire
	// on ajoute au model un backing bean de type FormulaireConnexion 
	// => pour mapper les champs du formulaire
	@GetMapping("/seconnecter")
    public String seconnecter(Model model){
        model.addAttribute("formulaireConnexion", new FormulaireConnexion());
        return "formulaireConnexion.html";
    }
    
	// méthode qui traite le formulaire rempli
	// teste si le login/pwd est ok et redirige vers la racine; sinon reboucle
	// jusqu'à ce qu'on mette une saisie valide
	@PostMapping("/seconnecter")
	// BindingResult => permet de récupérer les erreurs de validation
	// A mettre ABSOLUMENT aprés le paramétre correspondant au bean à valider
	public String seconnecter(@ModelAttribute @Valid FormulaireConnexion formulaireSoumis, 
			BindingResult bindingResult,
			Model model) {

		// Si la validation échoue, redirige vers la page de connexion
		if (bindingResult.hasErrors()) {
			return "formulaireConnexion.html";
		}

		if (formulaireSoumis.getLogin().equals(formulaireSoumis.getPwd())) {
			return "redirect:/";
		}
		model.addAttribute("interdit", "true");
		return "formulaireConnexion.html";
	}
}