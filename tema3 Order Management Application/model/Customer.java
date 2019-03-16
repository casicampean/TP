package model;
/**
 * 
 * @author Casi
 * contine atributele corespunzatoare cu tabelul
 * customer din baza de date
 */
public class Customer {
	private int id;
	private String name;
	public Customer(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

}

