package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;

public class SupprimerPizzaService extends MenuService {
	private String supprcode;

	@Override
	public void executeUC(Scanner scan, PizzaMemDao dao) {
		System.out.println("Suppression d�une pizza");
		System.out.println("Veuillez choisir le code de la pizza � surpprimer.");
		String supprcode = scan.next();
		
		//Appeler une methode "deletePizza" sur la dao
		dao.deletePizza(supprcode);
	}

}
