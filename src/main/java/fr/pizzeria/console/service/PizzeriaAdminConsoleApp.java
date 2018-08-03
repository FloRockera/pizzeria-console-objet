package fr.pizzeria.console.service;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoBDD;
import fr.pizzeria.exceptions.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws StockageException {

		Scanner scan = new Scanner(System.in);

		int choix = 0;
		Pizza pizza;

		// Pour le tableau de pizza stocké dans la dao, instancier
		IPizzaDao dao = new PizzaDaoBDD();

		// Saisir un choix sur le menu principal
		do {
			System.out.println(
					"***** Pizzeria Administration ***** \n 1. Lister les pizzas \n 2. Ajouter une nouvelle pizza \n 3. Mettre à jour une pizza \n 4. Supprimer une pizza \n 99. Sortir");
			choix = scan.nextInt();

			switch (choix) {

			// Affiche la liste sans les null
			case 1:
				ListerPizzasService listservice = new ListerPizzasService();
				listservice.executeUC(scan, dao);
				break;

			// Ajout d'une nouvelle pizza dans le tableau existant
			case 2:
				AjouterPizzaService ajservice = new AjouterPizzaService();
				try {
					ajservice.executeUC(scan, dao);
				} catch (StockageException e) {
					System.out.println(e.getMessage());
				}
				break;

			// Modification d'une pizza dans le tableau existant
			case 3:
				ModifierPizzaService modservice = new ModifierPizzaService();
				modservice.executeUC(scan, dao);
				break;

			// Supprimer une pizza
			case 4:
				SupprimerPizzaService supprservice = new SupprimerPizzaService();
				supprservice.executeUC(scan, dao);
				break;

			case 99:
				System.out.println("Aurevoir");
				break;

			default:
				System.out.println("Cette option de menu n'existe pas");
				break;

			}
		} while (choix != 99);

		scan.close();

	}

}