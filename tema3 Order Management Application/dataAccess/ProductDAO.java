package dataAccess;
/**
 * 
 * @author Casi
 *  clasa care se ocupa cu accesarea datelor din BD
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Product;

public class ProductDAO {
	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO product (id,name,quantity,price)"
			+ " VALUES (?,?,?,?)";
	private final static String findStatementString = "SELECT * FROM product where id = ?";
	private final static String selectStatementString = "SELECT * FROM product";
	private final static String deleteStatementString = "DELETE FROM product where id = ?";
	private final static String updateStatementString = "UPDATE product SET name = ? , quantity = ? , price = ? WHERE id = ?";


	public static Product findById(int id) {
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, id);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			int quantity = rs.getInt("quantity");
			int price = rs.getInt("price");
			toReturn = new Product(id, name, quantity, price);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	/**
	 * @param p
	 * @return returneaza id-ul Product-ului cu id-ul  dat ca parametru care a fost inserat in BD
	 */
	public static int insert(Product p) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, p.getId());
			insertStatement.setString(2, p.getName());
			insertStatement.setInt(3, p.getQuantity());
			insertStatement.setInt(4, p.getPrice());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	/**
	 * @param p
	 * metoda care modifica Product primit ca paramentru in baza de date
	 */
	public static void update(Product p) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setString(1, p.getName());
			updateStatement.setInt(2, p.getQuantity());
			updateStatement.setInt(3, p.getPrice());
			updateStatement.setInt(4, p.getId());
			updateStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	/**
	 * @param id
	 * metoda care sterge Product cu id-ul dat ca parametru
	 */
	public static void delete(int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setInt(1,id);
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProductDAO:delete " + e.getMessage());
		}finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	/**
	 * @return
	 * metoda care returneaza lista de Product luata din BD prin statement-ul SELECT* FROM Product;
	 */
	public static ArrayList<Product> select() {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement selectStatement = null;
		ArrayList<Product> product=new ArrayList<>();
		
		try {
			selectStatement = dbConnection.prepareStatement(selectStatementString);
			ResultSet rs = selectStatement.executeQuery();
			while (rs.next()) {
				
				 int id=rs.getInt("id");
				 String name=rs.getString("name");
				 int q=rs.getInt("quantity");
				 int pret=rs.getInt("price");
				 Product t=new Product(id,name,q,pret);
				 product.add(t);
			}
			
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:select " + e.getMessage());
		} finally {
			ConnectionFactory.close(selectStatement);
			ConnectionFactory.close(dbConnection);
		}
		return product;
	}

}
