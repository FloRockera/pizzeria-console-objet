package fr.pizzeria.console;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scan, PizzaMemDao dao) {
		
		System.out.println("Ajout d’une nouvelle pizza");
		System.out.println("Veuillez saisir le code : ");
		String code = scan.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String libelle = scan.next();
		System.out.println("Veuillez saisir le prix : ");
		double prix = scan.nextInt();
		
		//Appeler une methode "saveNewPizza" sur la dao
		Pizza pizza = new Pizza(0,code,libelle,prix);
		
		dao.saveNewPizza(pizza);
		
	}

}
