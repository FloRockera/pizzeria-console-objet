package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);

		int choix = 0;
		Pizza pizza;

		//Pour le tableau de pizza stocké dans la dao
		PizzaMemDao dao = new PizzaMemDao();
		

		// Saisir un choix sur le menu principal
		do {
			System.out.println("***** Pizzeria Administration ***** \n 1. Lister les pizzas \n 2. Ajouter une nouvelle pizza \n 3. Mettre à jour une pizza \n 4. Supprimer une pizza \n 99. Sortir");
			choix = scan.nextInt();

			switch (choix) {

			//Affiche la liste sans les null
			case 1:
				System.out.println("Liste des pizzas");
				
				//Appeler une methode "findAllPizzas" sur la dao
				Pizza[] pizzas = dao.findAllPizzas();
				
				for (int i=0; i<pizzas.length;i++){
					if (pizzas[i]!=null){
						System.out.println(pizzas[i].getCode()+" -> "+ pizzas[i].getLibelle()+" ( "+pizzas[i].getPrix()+" ) ");
					}
				}
				break;

				//Ajout d'une nouvelle pizza dans le tableau existant	
			case 2:
				
				AjouterPizzaService service = new AjouterPizzaService();
				service.executeUC(scan, dao);
				
				break;

				//Modification d'une pizza dans le tableau existant
			case 3:
				System.out.println("Mise à jour d’une pizza");
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				String modifcode = scan.next();
				System.out.println("Veuillez saisir le nouveau code");
				String nvcode = scan.next();
				System.out.println("Veuillez saisir le nouveau nom (sans espace) : ");
				String nvlibelle = scan.next();
				System.out.println("Veuillez saisir le nouveau prix : ");
				double nvprix = scan.nextInt();
				pizza = new Pizza(0,nvcode,nvlibelle,nvprix);
				//Appeler une methode "updatePizza" sur la dao
				dao.updatePizza(modifcode,pizza);
				
				break;
				
				//Supprimer une pizza
			case 4:
				System.out.println("Suppression d’une pizza");
				System.out.println("Veuillez choisir le code de la pizza à surpprimer.");
				String supprcode = scan.next();
				
				//Appeler une methode "deletePizza" sur la dao
				dao.deletePizza(supprcode);
				
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
