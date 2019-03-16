package model;
/**
 * 
 * @author Casi
 * contine atributele corespunzatoare cu tabelul
 * product din baza de date
 */

public class Product {
	private int id;
	private String name;
	private int quantity;
	private int price;
	public Product(int id,String name, int quantity, int price) {
		this.id=id;
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
