package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scan, PizzaMemDao dao) {
		
		System.out.println("Mise à jour d’une pizza");
		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		String modifcode = scan.next();
		System.out.println("Veuillez saisir le nouveau code");
		String nvcode = scan.next();
		System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
		String nvlibelle = scan.next();
		System.out.println("Veuillez saisir le nouveau prix : ");
		double nvprix = scan.nextInt();
		Pizza pizza = new Pizza(0, nvcode, nvlibelle, nvprix);

		// Appeler une methode "updatePizza" sur la dao
		dao.updatePizza(modifcode, pizza);
	}

}
