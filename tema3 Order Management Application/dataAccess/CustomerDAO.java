package dataAccess;
/**
 * 
 * @author Casi
 * clasa care se ocupa cu accesarea datelor din BD
 *
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Customer;


public class CustomerDAO {
	protected static final Logger LOGGER = Logger.getLogger(CustomerDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO customer (id,name)"
			+ " VALUES (?,?)";
	private final static String findStatementString = "SELECT * FROM customer where id = ?";
	private final static String selectStatementString = "SELECT * FROM customer";
	private final static String deleteStatementString = "DELETE FROM customer where id = ?";
	private final static String updateStatementString = "UPDATE customer SET name = ? WHERE id = ?";

	/**
	 * @param id
	 * @return returneaza Customerul de care are id-ul dat ca paramentru
	 */
	public static Customer findById(int id) {
		Customer toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, id);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			toReturn = new Customer(id, name);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"CustomerDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

	/**
	 * @param c
	 * @return retunrneaza id-ul customer-ului cu id-ul  dat ca parametru care a fost inserat in BD
	 */
	public static int insert(Customer c) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, c.getId());
			insertStatement.setString(2, c.getName());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CustomerDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	/**
	 * @param c
	 * metoda care modifica Clientul primit ca paramentru in baza de date
	 */
	public static void update(Customer c) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setString(1, c.getName());
			updateStatement.setInt(2, c.getId());
			updateStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CustomerDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	/**
	 * @param id
	 * metoda care sterge clientul cu id-ul dat ca parametru
	 */
	public static void delete(int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setInt(1,id);
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"CustomerDAO:delete " + e.getMessage());
		}finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	/**
	 * @return
	 * metoda care returneaza lista de Clienti luata din BD prin statement-ul SELECT* FROM customer;
	 */
	public static ArrayList<Customer> select() {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement selectStatement = null;
		ArrayList<Customer> order=new ArrayList<>();
		
		try {
			selectStatement = dbConnection.prepareStatement(selectStatementString);
			ResultSet rs = selectStatement.executeQuery();
			while (rs.next()) {
				
				 int id=rs.getInt("id");
				 String customer=rs.getString("name");
				 Customer t=new Customer(id,customer);
				 order.add(t);
			}
			
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:select " + e.getMessage());
		} finally {
			ConnectionFactory.close(selectStatement);
			ConnectionFactory.close(dbConnection);
		}
		return order;
	}

}
