package model;
/**
 * 
 * @author Casi
 *
 * contine atributele corespunzatoare cu tabelul
 * transport din baza de date
 */

public class Transport {
	private int id;
	private String name;
	private int price;
	public Transport(int id, String name, int pret) {
		this.id=id;
		this.name=name;	
		this.price=pret;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
