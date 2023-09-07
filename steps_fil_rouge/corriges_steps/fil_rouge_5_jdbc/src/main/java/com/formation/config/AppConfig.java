package com.formation.config;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan("com.formation")
// Au démarrage de l'application, Lire les entrées dans le fichier
// application.properties et les mettre à dispo
@PropertySource("classpath:/application.properties")
// Récupération dynamique du profil
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
@EnableWebMvc // permet d'activer les beans pour spring mvc (convertisseurs ...)
@EnableAspectJAutoProxy // Activer aspectj pour l'aop
@EnableTransactionManagement // activer les transactions
public class AppConfig {

	// Définir un bean qui permet de faire la conversion objet<->json
	// ce bean provient de la librairie jackson
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());

		viewResolver.setOrder(1); // optionel
		viewResolver.setViewNames(new String[] { "*.html", "*.xhtml" }); // optionel
		return viewResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		return templateEngine;
	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	//permet de gérer les connexions vers la base de données
	@Bean
	public DataSource dataSource() {
		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL("jdbc:h2:~/duplicataDatabase;INIT=RUNSCRIPT FROM 'classpath:schema.sql'");
		ds.setUser("sa");
		ds.setPassword("sa");
		return ds;
	}

	// interface que l'application utilise pour faire des opérations sql
	// utilise la datasource créée précédemment
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	// permet de faire les transactions
	@Bean
	public TransactionManager platformTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

}
