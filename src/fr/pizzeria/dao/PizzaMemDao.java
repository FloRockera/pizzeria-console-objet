package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	private Pizza[] pizzas;

	// Constructeur
	public PizzaMemDao() {

		// Création du tableau avec les objets pizza
		pizzas = new Pizza[100];
		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00);
	}

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		for (int i=0; i<pizzas.length;i++){
			if(pizzas[i]==null){
				pizzas[i] = pizza;
				break;
			}
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for (int i=0; i<pizzas.length;i++){
			if((pizzas[i]!=null) && (pizzas[i].code.equals(codePizza))){
				pizzas[i] = new Pizza(0, pizza.getCode(), pizza.getLibelle(), pizza.getPrix());
			}
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		for (int i=0; i<pizzas.length;i++){
			if (pizzas[i]!=null && pizzas[i].getCode().equals(codePizza)){
					pizzas[i] = null;
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}
	// "mem" pour stocker temporairement en mémoire

}
