package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scan, PizzaMemDao dao) {
		System.out.println("Liste des pizzas");
		
		//Appeler une methode "findAllPizzas" sur la dao
		Pizza[] pizzas = dao.findAllPizzas();
		
		for (int i=0; i<pizzas.length;i++){
			if (pizzas[i]!=null){
				System.out.println(pizzas[i].getCode()+" -> "+ pizzas[i].getLibelle()+" ( "+pizzas[i].getPrix()+" ) ");
			}
		}
		
	}

}
