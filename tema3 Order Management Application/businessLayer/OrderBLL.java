package businessLayer;
/**
 * 
 * @author Casi
 *
 *clasa care se ocupa cu realizarea operatilor pe baza de date,
 *apeland metodele din clasele din pachetul dataAcces
 */
import java.util.NoSuchElementException;
import dataAccess.OrderDAO;
import model.Order;


public class OrderBLL {
	public OrderBLL() {
	}
	/**
	 * @param id descrie id-ul comenzii care trebuie  gasit
	 * @return returneaza obiectul de tim Order in urma apelarii metodei din OrderDAO
	 */
	public Order findOrderById(int id) {
		Order st = OrderDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The order with id =" + id + " was not found!");
		}
		return st;
	}
	/**
	 * @param o descrie obiectul de tip Order
	 * @return metoda care retunreaza si care insereaza Order in BD
	 */
	public int insertOrder(Order o) {
		return OrderDAO.insert(o);
	}
	
	/**
	 * @param id descrie id-ul comenzii care trebuie sterse
	 */
	public void deleteOrder(int id) {
		OrderDAO.delete(id);
	}
	/**
	 * @param o descrie obiectul de tip Order
	 */
	public void updateOrder(Order o) {
		OrderDAO.update(o);
	}

}
