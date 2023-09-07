package com.formation.web.formulaires;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FormulaireConnexion {

	// valider les champs du formulaire
	@NotBlank
	@Size(min = 5, max = 20)
	private String login;
	
	
	private String pwd;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}