package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exceptions.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scan, PizzaMemDao dao) throws StockageException {
		
		System.out.println("Ajout d’une nouvelle pizza");
		System.out.println("Veuillez saisir le code : ");
		String code = scan.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String libelle = scan.next();
		System.out.println("Veuillez saisir la categorie (VIANDE, SANS_VIANDE, POISSON) : ");
		String nomCategorie = scan.next();
		
		CategoriePizza categorie = CategoriePizza.valueOf(nomCategorie);
		
		System.out.println("Veuillez saisir le prix : ");
		double prix = scan.nextInt();
		if (prix<=0){
			throw new StockageException("Le prix ne doit pas être négatif.");
		}
		else if (prix>=100){
			throw new StockageException("Le prix ne peut pas excéder 100€.");
		}
		
		//Appeler une methode "saveNewPizza" sur la dao
		Pizza pizza = new Pizza(0,code,libelle,categorie, prix);
		
		dao.saveNewPizza(pizza);
		
	}

}
