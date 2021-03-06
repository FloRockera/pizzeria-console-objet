package fr.pizzeria.console.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class SupprimerPizzaService extends MenuService {
	private String supprcode;

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) {
		System.out.println("Suppression d�une pizza");
		System.out.println("Veuillez choisir le code de la pizza � surpprimer.");
		String supprcode = scan.next();

		// Appeler une methode "deletePizza" sur la dao
		dao.deletePizza(supprcode);
	}

}