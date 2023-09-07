package com.formation.aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.formation.domain.Duplicata;

@Component
@Aspect
public class AspectTest {
	
	
	// Executer le code de la méthode
	//avant l'appel à la méthode createDuplicata
	//du bean duplicataService
	@Before("bean(duplicataService) && execution(* createDuplicata(..))")
	public void test(JoinPoint joinpoint) {
		System.out.println("///////////////// Ici un Aspect Before //////////");
	}
	
	@Before("bean(duplicataService) && execution(* createDuplicata(..))")
	public void logueMethodParamaters(JoinPoint joinpoint) {
		System.out.println("///////////////// Paramétres de la méthode //////////");
		System.out.println(joinpoint.getSignature());
	}
	
	@Around("bean(duplicataService) && execution(* createDuplicata(..))")
	public Duplicata ajouterFR_(ProceedingJoinPoint joinpoint) throws Throwable {
		
		System.out.println("///////////////// Ajout de FR_ pour userId //////////");
		System.out.println(joinpoint.getSignature());
		//récuperation du tableau d'arguments
		Object[] arguments = joinpoint.getArgs();
		//Récuperation de l'argument userId en position 1
		String userid = (String) arguments[0];
		//Récuperation de l'argument montant en position 2
		int montant = (Integer) arguments[1];
		
		//Construire un nouveau tableau d'arguments
		Object[] new_args = new Object[] {"FR_"+userid, Integer.valueOf(montant)};
		//appel à la méthode réelle
		Duplicata duplicata = (Duplicata) joinpoint.proceed(new_args);
		return duplicata;
	}

}
