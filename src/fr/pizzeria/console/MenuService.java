package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exceptions.StockageException;

public abstract class MenuService {

	//Signature de méthode, oblige les classes filles à l'utiliser
	abstract void executeUC(Scanner scanner, PizzaMemDao dao) throws StockageException;
	// abstract void executeUC(Scanner scanner, PizzaMemDao dao) throws StockageException;
	
	
}