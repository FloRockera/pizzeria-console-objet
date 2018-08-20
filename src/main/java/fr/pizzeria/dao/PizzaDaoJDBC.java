package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJDBC implements IPizzaDao {

	public Connection creerConnexion() throws SQLException {

		// Localiser la BDD
		String jdbcUrl = "jdbc:mysql://localhost:3306/liste_pizzas";

		// Nom d'utilisateur
		String nomUtilisateur = "root";

		// Mot de passe d'accès à la BDD
		String motDePasse = "";

		// Création de la connexion à la BDD
		Connection connection = DriverManager.getConnection(jdbcUrl, nomUtilisateur, motDePasse);

		// Création PrepareStatement (instruction SQL à exécuter)
		//

		return connection;

	}

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<Pizza>();

		try {
			Connection connection = creerConnexion();
			PreparedStatement statement = connection.prepareStatement("select * from pizza");
			ResultSet resultSet = statement.executeQuery();

			// tant qu'il y a une prochaine ligne de résultat à exploiter
			while (resultSet.next()) {

				String code = resultSet.getString("CODE");
				String nom = resultSet.getString("NOM");
				String categorie = resultSet.getString("CATEGORIE");
				Double prix = resultSet.getDouble("PRIX");

				Pizza pizza = new Pizza();
				pizza.setCode(code);
				pizza.setLibelle(nom);
				pizza.setCateg(CategoriePizza.valueOf(categorie));
				pizza.setPrix(prix);
				pizzas.add(pizza);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		try {
			Connection connection = creerConnexion();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO pizza (CODE, NOM, CATEGORIE, PRIX) values(?,?,?,?)");
			// Exécution d'une requête d'écriture qui retourne un entier
			// représentant le nombre de lignes affectées par la requête
			// réalisée
			statement.setString(1, pizza.getCode());
			statement.setString(2, pizza.getLibelle());
			statement.setString(3, pizza.getCateg().name());
			statement.setDouble(4, pizza.getPrix());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		try {
			Connection connection = creerConnexion();
			PreparedStatement statement = connection
					.prepareStatement("UPDATE pizza (CODE, NOM, CATEGORIE, PRIX) SET values(?,?,?,?)");
			statement.setString(1, pizza.getCode());
			statement.setString(2, pizza.getLibelle());
			statement.setString(3, pizza.getCateg().name());
			statement.setDouble(4, pizza.getPrix());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		if (pizzaExists(codePizza)) {
			try (PreparedStatement statement = connection.prepareStatement("delete from pizzas where code=?")) {
				statement.setString(1, codePizza);

				try (ResultSet resultSet = statement.executeQuery()) {

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("La pizza que vous voulez supprimez n'existe pas");
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}
}
