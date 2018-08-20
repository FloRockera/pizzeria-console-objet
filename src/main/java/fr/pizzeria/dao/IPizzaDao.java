package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exceptions.StockageException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao extends AutoCloseable {

	List<Pizza> findAllPizzas();

	void saveNewPizza(Pizza pizza) throws StockageException;

	void updatePizza(String codePizza, Pizza pizza);

	void deletePizza(String codePizza);

	Pizza findPizzaByCode(String codePizza);

	boolean pizzaExists(String codePizza);

	default void close() {

	}
}