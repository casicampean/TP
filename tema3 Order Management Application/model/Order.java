package model;
/**
 * 
 * @author Casi
 * contine atributele corespunzatoare cu tabelul
 * order din baza de date
 *
 */

public class Order {
	private int id;
	private int customerId;
	private int productId;
	private int idTransport;
	public Order(int id, int c,int p,int t) {
		this.id=id;
		this.customerId=c;
		this.productId=p;
		this.idTransport=t;
	}
	
	public int getId() {
		return id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getIdTransport() {
		return idTransport;
	}
	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}
	
	

}
