package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;

public abstract class MenuService {

	//Signature de m�thode, oblige les classes filles � l'utiliser
	public abstract void executeUC(Scanner scanner, PizzaMemDao dao);
	
	
}