package fr.pizzeria.console.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exceptions.StockageException;

public abstract class MenuService {

	// Signature de méthode, oblige les classes filles à l'utiliser
	abstract void executeUC(Scanner scanner, IPizzaDao dao) throws StockageException;
	// abstract void executeUC(Scanner scanner, PizzaMemDao dao) throws
	// StockageException;

}