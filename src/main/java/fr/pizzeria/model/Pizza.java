package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "CODE")
	private String code;

	@Column(name = "LIBELLE")
	private String libelle;

	// @Rule(min = 10)
	@Column(name = "PRIX")
	private double prix;

	@Column(name = "CATEGORIE")
	private CategoriePizza categ;

	private CategoriePizza getCateg() {
		return categ;
	}

	public Pizza() {
		super();
	}

	// constructeur Pizza
	public Pizza(int nvid, String nvcode, String nvlibelle, CategoriePizza nvCateg, double nvprix) {
		id = nvid;
		code = nvcode;
		libelle = nvlibelle;
		categ = nvCateg;
		prix = nvprix;
	}

	static int compteur;

	public Pizza(String code, String libelle, double prix, CategoriePizza categ) {
		compteur++;
		this.id = compteur;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categ = categ;
	}

	// Méthodes lecture/écriture : Générer les getters and setters avec le clic
	// droit dans "sources"
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

	public void setCateg(CategoriePizza categ) {
		this.categ = categ;
	}

	// Methode toString
	@Override
	public String toString() {
		return "Pizza [id=" + id + ", code=" + code + ", libelle=" + libelle + ", prix=" + prix + ", categ=" + categ
				+ "]";
	}

}