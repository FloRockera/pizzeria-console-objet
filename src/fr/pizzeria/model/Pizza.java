package fr.pizzeria.model;

public class Pizza {

	public int id;
	public String code;
	public String libelle;
	public double prix;
	
	// constructeur Pizza
	public Pizza(int nvid, String nvcode, String nvlibelle, double nvprix) {
		id = nvid;
		code = nvcode;
		libelle = nvlibelle;
		prix = nvprix;
	}

	//Méthodes lecture/écriture : Générer les getters and setters avec le clic droit dans "sources"
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
}
