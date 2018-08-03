package fr.pizzeria.console.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {

	// --------------------------
	// ARRAYLIST-------------------------------------------

	@Override
	public void executeUC(Scanner scan, IPizzaDao dao) {
		System.out.println("Liste des pizzas");

		// Appeler une methode "findAllPizzas" sur la dao
		List<Pizza> pizzas = (List<Pizza>) dao.findAllPizzas();

		for (int i = 0; i < pizzas.size(); i++) {
			// if (pizzas.get(i)!=null){
			System.out.println(pizzas.get(i).getCode() + " -> " + pizzas.get(i).getLibelle() + " ( "
					+ pizzas.get(i).getPrix() + " ) ");
			// }
		}

		// --------------------------
		// TABLEAU-------------------------------------------

		/*
		 * @Override public void executeUC(Scanner scan, PizzaMemDao dao) {
		 * System.out.println("Liste des pizzas");
		 * 
		 * //Appeler une methode "findAllPizzas" sur la dao Pizza[] pizzas =
		 * dao.findAllPizzas();
		 * 
		 * for (int i=0; i<pizzas.length;i++){ if (pizzas[i]!=null){
		 * System.out.println(pizzas[i].getCode()+" -> "+
		 * pizzas[i].getLibelle()+" ( "+pizzas[i].getPrix()+" ) "); } }
		 */

	}

}