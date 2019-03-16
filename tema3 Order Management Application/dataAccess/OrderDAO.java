package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Order;
/**
 * 
 * @author Casi
 * clasa care se ocupa cu accesarea datelor din BD
 *
 */
public class OrderDAO {
	protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO order (id,customer,product,transport)"
			+ " VALUES (?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM order where id = ?";
	private final static String deleteStatementString = "DELETE FROM order where id = ?";
	private final static String updateStatementString = "UPDATE order SET order = ? , product = ? , transport = ? WHERE id = ?";
	
	/**
	 * @param id
	 * @return Order
	 * returneaza un obiect de tip Order care are id-ul dat ca si parametru
	 */
	public static Order findById(int id) {
		Order toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, id);
			rs = findStatement.executeQuery();
			rs.next();

			int customer = rs.getInt("customer");
			int product = rs.getInt("product");
			int transport = rs.getInt("transport");
			toReturn = new Order(id,customer,product,transport);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"OrderDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	/**
	 * @param o descrie parametrul de tip Order
	 * @return returneaza id-ul Order-ului cu id-ul  dat ca parametru care a fost inserat in BD
	 */
	public static int insert(Order order) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, order.getId());
			insertStatement.setInt(2, order.getCustomerId());
			insertStatement.setInt(3, order.getProductId());
			insertStatement.setInt(4, order.getIdTransport());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	/**
	 * @param f
	 * metoda care modifica Order primit ca paramentru in baza de date
	 */
	public static void update(Order o) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setInt(1, o.getCustomerId());
			updateStatement.setInt(2, o.getProductId());
			updateStatement.setInt(3, o.getId());
			updateStatement.setInt(4, o.getIdTransport());
			updateStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	/**
	 * @param id
	 * metoda care sterge Order cu id-ul dat ca parametru
	 */
	public static void delete(int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setInt(1,id);
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"OrderDAO:delete " + e.getMessage());
		}finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	

}



