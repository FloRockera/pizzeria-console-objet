package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
public class PizzaMemDaoTest {

	@Test
	public void testFindAllPizzas() {
		PizzaMemDao dao = new PizzaMemDao();
		assertEquals(8,dao.getPizzas().size());
	}


	@Test
	public void testSaveNewPizza() {
		PizzaMemDao dao = new PizzaMemDao();
		Pizza p = new Pizza(0, "VEG", "Pépéroni", CategoriePizza.VIANDE, 12.50);
		dao.saveNewPizza(p);
		assertEquals(9,dao.getPizzas().size());
	}


	@Test
	public void testUpdatePizza() {
		PizzaMemDao dao = new PizzaMemDao();

		assertTrue(dao.findAllPizzas().size()==8);

		dao.updatePizza("CAN",new Pizza(0, "VEG", "Vegetarienne", CategoriePizza.VIANDE, 16.30));

		assertTrue(dao.findAllPizzas().size()==8);

		assertNull(dao.findPizzaByCode("CAN"));
		assertNotNull(dao.findPizzaByCode("VEG"));
	}


	@Test
	public void testDeletePizza() {
		/*	PizzaMemDao dao = new PizzaMemDao();
		Pizza p = new Pizza(0, "VEG", "Pépéroni", CategoriePizza.VIANDE, 12.50);
		dao.saveNewPizza(p);
		
	}*/
		PizzaMemDao dao = new PizzaMemDao();
		//Pizza p = new Pizza(3, "FRO", "La 4 fromages", CategoriePizza.SANS_VIANDE, 12.00);
		dao.deletePizza("FRO");
		assertNull(dao.findPizzaByCode("FRO"));
		assertEquals(7,dao.getPizzas().size());
		
	}



	//@Test
	//public void testFindPizzaByCode() {
	//	
	//}
	//
	//@Test
	//public void testPizzaExists() {
	//	fail("Not yet implemented");
	//}

}
