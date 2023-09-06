package com.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.formation")
// Au démarrage de l'application, Lire les entrées dans le fichier
// application.properties et les mettre à dispo
@PropertySource("classpath:/application.properties")
// Récupération dynamique du profil
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties",ignoreResourceNotFound = true)
public class AppConfig {

}
