package com.formation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.formation.domain.Duplicata;
import com.formation.domain.User;

@Component
public class DuplicataService {

	private List<Duplicata> duplicatas = new CopyOnWriteArrayList<Duplicata>();

	@Autowired
	private UserService userService;
	
	private String cdnUrl;
	
	public DuplicataService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
		this.userService = userService;
		this.cdnUrl = cdnUrl;
	}

	public Duplicata createDuplicata(String userId, int montant) {

		// Verification si le user existe ou pas
		User user_id_db = userService.findById(userId);
		if (user_id_db == null) {
			throw new IllegalArgumentException();
		}

		Duplicata duplicata = new Duplicata();
		// générer un id
		String randomId_duplicata = UUID.randomUUID().toString();
		duplicata.setId(randomId_duplicata);
		duplicata.setMontant(montant);
		duplicata.setUserid(userId);
		//préfixer le pdf avec le bon cdn
		duplicata.setPdfurl(cdnUrl + "/images/default/sample.pdf");
		

		// Ajouter dans la liste
		duplicatas.add(duplicata);

		return duplicata;

	}
	
	public List<Duplicata> listDuplicatas() {
		return duplicatas;
	}

}
