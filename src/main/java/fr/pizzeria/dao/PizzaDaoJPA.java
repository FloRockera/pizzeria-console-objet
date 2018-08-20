package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

public class PizzaDaoJPA implements IPizzaDao {

	EntityManagerFactory emf;

	public void close() {
		emf.close();
	}

	public List<Pizza> findAllPizzas() {

		// Création de la factory
		this.emf = Persistence.createEntityManagerFactory("pizzeria-console-objet");
		EntityManager em = this.emf.createEntityManager();

		// Trouver les pizzas
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> pizzas = query.getResultList();
		em.close();
		return pizzas;

	}
}
