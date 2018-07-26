package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {


	//-------------------------- TABLEAU-------------------------------------------
	// Création du tableau avec les objets pizza

	/* private Pizza[] pizzas;
		 pizzas = new Pizza[100];
		pizzas[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza(2, "REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		pizzas[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza(6, "ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza(7, "IND", "L'indienne", 14.00); */
	//----------------------------FIN DU TABLEAU------------------------------------

	private List<Pizza> pizzas;

	// ________________________________________________________
	//---------CONSTRUCTEUR ARRAYLIST-----------------
	public PizzaMemDao() {
		pizzas = new ArrayList<>(); // ne pas recréer une variable (déjà déclarée à l'ext) sinon elle sera locale et détruite à la sortie du constructeur
		pizzas.add(new Pizza(0, "PEP", "Pépéroni", CategoriePizza.VIANDE, 12.50));
		pizzas.add(new Pizza(1, "MAR", "Margherita", CategoriePizza.VIANDE, 14.00));
		pizzas.add(new Pizza(2, "REIN", "La Reine", CategoriePizza.VIANDE, 11.50));
		pizzas.add(new Pizza(3, "FRO", "La 4 fromages", CategoriePizza.SANS_VIANDE, 12.00));
		pizzas.add(new Pizza(4, "CAN", "La cannibale", CategoriePizza.VIANDE, 12.50));
		pizzas.add(new Pizza(5, "SAV", "La savoyarde", CategoriePizza.VIANDE, 13.00));
		pizzas.add(new Pizza(6, "ORI", "L'orientale", CategoriePizza.VIANDE, 13.50));
		pizzas.add(new Pizza(7, "IND", "L'indienne", CategoriePizza.VIANDE, 14.00));
	}



	// ________________________________________________________
	//---------METHODES ARRAYLIST-----------------


	// Méthode pour lister les pizzas
	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}
	
	

	// Méthode pour ajouter une pizza
	@Override
	public void saveNewPizza(Pizza pizza) {
		pizzas.add(pizza);
	}


	// Méthode pour modifier une pizza
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		Pizza pizzaModif = findPizzaByCode(codePizza);
		if (pizzaModif!=null){
			pizzaModif.setCode(pizza.getCode());
			pizzaModif.setLibelle(pizza.getLibelle());
			pizzaModif.setPrix(pizza.getPrix());
		}
	}

	// Méthode pour supprimer une pizza
	@Override
	public void deletePizza(String codePizza) {
		for(int i=0;i<pizzas.size();i++){
			if (pizzas.get(i).getCode().equals(codePizza)){
				pizzas.remove(i);
			}
		}
	}


	// Méthode pour trouver une pizza grâce au code
	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (int i=0 ; i<pizzas.size(); i++){
			if (pizzas.get(i).getCode().equals(codePizza)){
				return pizzas.get(i);
			}
		}
		return null;
	}


	// Méthode toString
	//@toString(apres"->",uppercase=true);
	public String toString() {
		return "PizzaMemDao [pizzas=" + pizzas + "]";
	}


	// Getters et Setters
	public List<Pizza> getPizzas() {
		return pizzas;
	}


	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		return findPizzaByCode(codePizza)!=null;
	}



	public PizzaMemDao(List<Pizza> pizzas) {
		super();
		this.pizzas = pizzas;
	}


	// ________________________________________________________
	//---------METHODES TABLEAU-----------------

	/*@Override
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
	 */


}