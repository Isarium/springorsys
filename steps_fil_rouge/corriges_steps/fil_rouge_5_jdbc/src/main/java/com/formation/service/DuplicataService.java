package com.formation.service;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.formation.domain.Duplicata;

@Component
public class DuplicataService {

	private UserService userService;

	private final JdbcTemplate jdbcTemplate;

	private String cdnUrl;

	public DuplicataService(UserService userService, JdbcTemplate jdbcTemplate, @Value("${cdn.url}") String cdnUrl) {
		this.jdbcTemplate = jdbcTemplate;
		this.userService = userService;
		this.cdnUrl = cdnUrl;
	}

	@Transactional
	public Duplicata createDuplicata(String userId, int montant) {
		System.out.println("Une transaction est t-il en cours? = " + TransactionSynchronizationManager.isActualTransactionActive());

		String generatedPdfUrl = cdnUrl + "/images/default/sample.pdf";

		//Classe permettant d'extraire d'une ligne donnée l'uuid de la ligne
		KeyHolder keyHolder = new GeneratedKeyHolder();

		// Executer la requête : passer en paramétre la query, et le keyholder
		// (qui permettra de récupérer la uuid)
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(
					"insert into duplicatas (user_id, pdf_url, montant) values (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, userId); //
			ps.setString(2, generatedPdfUrl);
			ps.setInt(3, montant);
			return ps;
		}, keyHolder);

		// Récupération du uuid
		String uuid = !keyHolder.getKeys().isEmpty()
				? ((UUID) keyHolder.getKeys().values().iterator().next()).toString()
				: null;

		Duplicata duplicata = new Duplicata();
		duplicata.setId(uuid);
		duplicata.setPdfurl(generatedPdfUrl);
		duplicata.setMontant(montant);
		duplicata.setUserid(userId);
		return duplicata;

	}

	@Transactional
	public List<Duplicata> listDuplicatas() {
		System.out.println("Une transaction est t-il en cours? = " + TransactionSynchronizationManager.isActualTransactionActive());
		return jdbcTemplate.query("select id, user_id, pdf_url, montant from duplicatas", (resultSet, rowNum) -> {
			Duplicata duplicata = new Duplicata();
			duplicata.setId(resultSet.getObject("id").toString());
			duplicata.setPdfurl(resultSet.getString("pdf_url"));
			duplicata.setUserid(resultSet.getString("user_id"));
			duplicata.setMontant(resultSet.getInt("montant"));
			return duplicata;
		});
	}

}