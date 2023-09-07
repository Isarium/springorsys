package com.formation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.DuplicataDto;
import com.formation.model.Duplicata;
import com.formation.service.DuplicataService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@RestController
@Validated
public class DuplicataControlleur {

	private final DuplicataService duplicataService;

	public DuplicataControlleur(DuplicataService duplicataService) {
		this.duplicataService = duplicataService;
	}

	@GetMapping("/duplicatas")
	// @RequestMapping(value = "/duplicatas", method = RequestMethod.GET)
	public List<Duplicata> duplicatas() {
		return duplicataService.listDuplicatas();
	}

	@PostMapping("/duplicatas")
	// @PostMapping permet de traiter les requêtes de type POST
	// @RequestParam permet de récupérer la valeur d'un paramètre HTTP
	public Duplicata createDuplicata(@RequestParam("user_id") @NotBlank String userId, @RequestParam @Min(1) @Max(5000) Integer montant) {
		return duplicataService.createDuplicata(userId, montant);

	}

	@PostMapping("/duplicatas/{userId}/{montant}")
	public Duplicata createDuplicata2(@PathVariable @NotBlank String userId, @PathVariable @Min(1) @Max(5000) Integer montant) {
		return duplicataService.createDuplicata(userId, montant);
	}
	
	@PostMapping("/duplicatas_dto")
	//@RequestBody permet de parser le json reçu en une classe DuplicataDto
    public Duplicata createDuplicata_dto(@RequestBody @Valid DuplicataDto duplicataDto) {
        return duplicataService.createDuplicata(duplicataDto.getUserId(), duplicataDto.getMontant());
    }


}