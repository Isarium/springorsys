package com.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
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

}
