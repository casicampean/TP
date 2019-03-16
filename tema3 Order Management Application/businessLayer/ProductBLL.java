package businessLayer;
/**
 * 
 * @author Casi
 * clasa care se ocupa cu realizarea operatilor pe baza de date,
 *apeland metodele din clasele din pachetul dataAcces
 *
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;
import dataAccess.ProductDAO;
import model.Product;

public class ProductBLL {
	public ProductBLL() {
	}
	/**
	 * @param id descrie id-ul produsului care trebuie gasit
	 * @return metoda care returneaza obiectul de timp Product in urma apelarii metodei din ProductDAO
	 */
	public Product findProductById(int id) {
		Product st = ProductDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The product with id =" + id + " was not found!");
		}
		return st;
	}
	/**
	 * @param p descrie obiectul de tip Produs
	 * @return metoda care retunreaza si care insereaza Product in BD
	 */
	public int insertProduct(Product p) {
		return ProductDAO.insert(p);
	}
	/**
	 * @param id descrie id-ul produsului care trebuie sters
	 */
	public void deleteProduct(int id) {
		ProductDAO.delete(id);
	}
	/**
	 * @param p descrie produsul care trebuie modificat
	 */
	public void updateProduct(Product p) {
		ProductDAO.update(p);
	}
	/**
	 * @return returneaza o lista de produse
	 */
	public ArrayList<Product> selectProduct(){
		ArrayList<Product> tr=ProductDAO.select();
		return tr;
		
	}

}
