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
import dataAccess.TransportDAO;
import model.Transport;


public class TransportBLL {
	public TransportBLL() {
	}

	/**
	 * @param id descrie id-ul transportului care treuie gasit
	 * @return metoda care returneaza obiectul de timp transport in urma apelarii metodei din TransportDAO
	 */
	public Transport findTransportById(int id) {
		Transport st = TransportDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The provider with id =" + id + " was not found!");
		}
		return st;
	}
	/**
	 * @param c descrie Trasnportul  care trebuie iserat
	 * @return metoda care returneaza si care insereaza Transport in BD
	 */
	public  int insertTransport(Transport c) {
		return TransportDAO.insert(c);
	}
	/**
	 * @param id descrie id-ul transportului care urmeaza sa fie sters
	 */
	public void deleteTransport(int id) {
		TransportDAO.delete(id);
	}
	/**
	 * @param c descrie id-ul transportului care trebuie modificat
	 */
	public void updateTransport(Transport c) {
		TransportDAO.update(c);
	}
	/**
	 * @return returneaza ista de obiecte de tip Transport
	 */
	public ArrayList<Transport> selectTransport(){
		ArrayList<Transport> tr=TransportDAO.select();
		return tr;
		
	}
}
