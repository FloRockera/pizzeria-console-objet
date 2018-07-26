package fr.pizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.console.AjouterPizzaService;
import fr.pizzeria.exceptions.StockageException;

public class DemoRuleScanner {

//	Création d'une "Rule" qui va permettre
//	* de substituer le System.in utilisé par le Scanner
//	* par un mock: systemInMock
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void testExecuteUC(){

		
		// J'alimente le mock avec les paramètres de l'objet pizza à découper
		systemInMock.provideLines("PEP", "Pépéroni", "VIANDE", "12");
		

		PizzaMemDao pizzaMeamDao = new PizzaMemDao();
		Scanner scan = new Scanner(System.in);
		
		//TEST AJOUTER UNE PIZZA
		AjouterPizzaService service = new AjouterPizzaService();
		try {
			service.executeUC(scan, pizzaMeamDao);
		} catch (StockageException e) {
			fail();
		}
		assertEquals(9,pizzaMeamDao.getPizzas().size());
		
		

	}
}
