package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

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

			//Affiche la liste sans les null
			case 1:
				System.out.println("Liste des pizzas");
				for (int i=0; i<pizzas.length;i++){
					if(pizzas[i]!=null){
						System.out.println(pizzas[i].getCode()+" -> "+ pizzas[i].getLibelle()+" ( "+pizzas[i].getPrix()+" ) ");
					}
				}
				break;

				//Ajout d'une nouvelle pizza dans le tableau existant	
			case 2:
				System.out.println("Ajout d’une nouvelle pizza");
				System.out.println("Veuillez saisir le code : ");
				String code = scan.next();
				System.out.println("Veuillez saisir le nom (sans espace) : ");
				String libelle = scan.next();
				System.out.println("Veuillez saisir le prix : ");
				double prix = scan.nextInt();
				for (int i=0; i<pizzas.length;i++){
					if(pizzas[i]==null){
						pizzas[i] = new Pizza(0, code, libelle, prix);
						break;
					}
				}
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
				for (int i=0; i<pizzas.length;i++){
					if((pizzas[i]!=null) && (pizzas[i].code.equals(modifcode))){
						pizzas[i] = new Pizza(0, nvcode, nvlibelle, nvprix);
					}
				}
				break;
				//Supprimer une pizza
			case 4:
				System.out.println("Suppression d’une pizza");
				System.out.println("Veuillez choisir le code de la pizza à surpprimer.");
				String supprcode = scan.next();
				for (int i=0; i<pizzas.length;i++){
					if (pizzas[i]!=null && pizzas[i].getCode().equals(supprcode)){
							pizzas[i] = null;
					}
				}
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
