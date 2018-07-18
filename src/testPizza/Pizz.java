package testPizza;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class Pizz{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int choix = 0;

		
		// Création du tableau avec les objets pizza
		Pizza[] pizzas = new Pizza[100];
		pizzas[0] = new Pizza(0,"PEP","Pépéroni",12.50);
		pizzas[1] = new Pizza(1,"MAR","Margherita",14.00);
		pizzas[2] = new Pizza(2,"REIN","La Reine",11.50);
		pizzas[3] = new Pizza(3,"FRO","La 4 fromages",12.00);
		pizzas[4] = new Pizza(4,"CAN","La cannibale",12.50);
		pizzas[5] = new Pizza(5,"SAV","La savoyarde",13.00);
		pizzas[6] = new Pizza(6,"ORI","L'orientale",13.50);
		pizzas[7] = new Pizza(7,"IND","L'indienne",14.00);
		
		
		// Saisir un choix sur le menu principal
		do {
			System.out.println("***** Pizzeria Administration ***** \n 1. Lister les pizzas \n 2. Ajouter une nouvelle pizza \n 3. Mettre à jour une pizza \n 4. Supprimer une pizza \n 99. Sortir");
			choix = scan.nextInt();

			switch (choix) {
			case 1:
				System.out.println("Liste des pizzas");
				break;
			case 2:
				System.out.println("Ajout d’une nouvelle pizza");
				break;
			case 3:
				System.out.println("Mise à jour d’une pizza");
				break;
			case 4:
				System.out.println("Suppression d’une pizza");
				break;
			default:
				System.out.println("Cette option de menu n'existe pas");
				break;
			}
		} while (choix != 99);
		System.out.println("Aurevoir");

		scan.close();
		
		
	}

}
