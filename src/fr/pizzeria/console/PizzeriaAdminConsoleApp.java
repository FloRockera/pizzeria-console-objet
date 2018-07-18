package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);

		int choix =0;

		do {
			System.out.println("***** Pizzeria Administration ***** \n 1. Lister les pizzas \n 2. Ajouter une nouvelle pizza \n 3. Mettre à jour une pizza \n 4. Supprimer une pizza \n 99. Sortir");	;
			choix = scan.nextInt();

			switch (choix){
			case 1 :
				System.out.println("Liste des pizzas");
				break;
			case 2 :
				System.out.println("Ajout d’une nouvelle pizza");
				break;
			case 3 :
				System.out.println("Mise à jour d’une pizza");
				break;
			case 4 :
				System.out.println("Suppression d’une pizza");
				break;
			default:
				System.out.println("Cette option de menu n'existe pas");
				break;
			} 
		} while (choix!=99);
		System.out.println("Aurevoir");

		scan.close();

		
		
		
	}


}
