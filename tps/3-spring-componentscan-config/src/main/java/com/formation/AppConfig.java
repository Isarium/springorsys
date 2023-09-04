package com.formation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;


/**
 * Cette classe joue le même rôle que le fichier xml
 * 
 */
@Configuration
@ComponentScan("com.formation") // définir les packages contenant les beans à gérer (classes annotées avec @Component)
public class AppConfig {


}