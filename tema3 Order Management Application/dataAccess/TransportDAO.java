package dataAccess;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Transport;


/**
 * 
 * @author Casi
 * clasa care se ocupa cu accesarea datelor din BD
 *
 */
public class TransportDAO {
	protected static final Logger LOGGER = Logger.getLogger(TransportDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO transport (id,name,price)"
			+ " VALUES (?,?,?)";
	private final static String findStatementString = "SELECT * FROM transport where id = ?";
	private final static String deleteStatementString = "DELETE FROM transport where id = ?";
	private final static String updateStatementString = "UPDATE transport SET name = ? , price = ? WHERE id = ?";
	private final static String selectStatementString = "SELECT * FROM transport";

	/**
	 * @param id
	 * @return Transport
	 * returneaza un obiect de tip transport care are id-ul dat ca si parametru
	 */
	public static Transport findById(int id) {
		Transport toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, id);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			int price = rs.getInt("price");
			toReturn = new Transport(id, name,price);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"TransportDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

	/**
	 * @param c
	 * @return returneaza id-ul Transportului cu id-ul  dat ca parametru care a fost inserat in BD
	 */
	public static int insert(Transport f) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, f.getId());
			insertStatement.setString(2, f.getName());
			insertStatement.setInt(3, f.getPrice());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "TransportDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	
	/**
	 * @param f
	 * metoda care modifica Transportul primit ca paramentru in baza de date
	 */
	public static void update(Transport f) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement updateStatement = null;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			updateStatement.setString(1, f.getName());
			updateStatement.setInt(2, f.getPrice());
			updateStatement.setInt(3, f.getId());
			updateStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "TransportDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
	/**
	 * @param id
	 * metoda care sterge transportul cu id-ul dat ca parametru
	 */
	public static void delete(int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			deleteStatement.setInt(1,id);
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"TransportDAO:delete " + e.getMessage());
		}finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(dbConnection);
		}
	}
	
	/**
	 * @return
	 * metoda care returneaza lista de Transport luata din BD prin statement-ul SELECT* FROM Transport;
	 */
	public static ArrayList<Transport> select() {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement selectStatement = null;
		ArrayList<Transport> transport=new ArrayList<>();
		
		try {
			selectStatement = dbConnection.prepareStatement(selectStatementString);
			ResultSet rs = selectStatement.executeQuery();
			while (rs.next()) {
				
				 int id=rs.getInt("id");
				 String name=rs.getString("name");
				 int pret=rs.getInt("price");
				 Transport t=new Transport(id,name,pret);
				 transport.add(t);
			}
			
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "TransportDAO:select " + e.getMessage());
		} finally {
			ConnectionFactory.close(selectStatement);
			ConnectionFactory.close(dbConnection);
		}
		return transport;
	}
}
