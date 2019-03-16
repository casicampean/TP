package businessLayer;
/**
 * 
 * @author Casi
 *clasa care se ocupa cu realizarea operatilor pe baza de date,
 *apeland metodele din clasele din pachetul dataAcces
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;
import dataAccess.CustomerDAO;
import model.Customer;


public class CustomerBLL {
	public CustomerBLL() {
	}
	/**
	 * @param id descr
	 * @return  returneaza obiectul de tip Customer in urma apelarii metodei din CustomerDAO
	 */
	public Customer findCustomerById(int id) {
		Customer st = CustomerDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The customer with id =" + id + " was not found!");
		}
		return st;
	}

	/**
	 * @param c descr
	 * @return metoda care retunreaza si care insereaza clinetul in BD
	 */
	public  int insertCustomer(Customer c) {
		return CustomerDAO.insert(c);
	}
	 
	/**
	 * @param id descrie id-ul clientului care trebuie sters
	 * metoda care sterge in BD clinetul cu id dat ca parametru
	 */
	public void deleteCustomer(int id) {
		 CustomerDAO.delete(id);
	}
	
	/**
	 * @param c  modifica clientul c cu id-ul dat ca parametru din BD
	 */
	public void updateCustomer(Customer c) {
		 CustomerDAO.update(c);
	}
	
	/**
	 * @return returneaza o lista de Customeri
	 */
	public ArrayList<Customer> selectCustomer(){
		ArrayList<Customer> tr=CustomerDAO.select();
		return tr;
		
	}

}
