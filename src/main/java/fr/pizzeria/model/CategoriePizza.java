package fr.pizzeria.model;

public enum CategoriePizza {

	// Valeurs de l'énumération
	VIANDE ("Viande"), POISSON ("Poisson"), SANS_VIANDE ("Sans viande");
	
	
	// Attribut
	private String nom;
	
	//Attribut de type CategoriePizza
	private CategoriePizza(String nom){
		this.nom = nom;
	}
	
	
	// Getters et Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}