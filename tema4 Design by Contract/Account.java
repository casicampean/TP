package tema4;

import java.util.Observable;

@SuppressWarnings("deprecation")
public abstract class  Account extends  Observable implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double money;
	protected String tip;
	protected String person;
	protected int id;
	
	public Account(int id,double m, String person) {
		this.id=id;
		//Suma = Suma+ (dobanda*suma)/100
		this.money=m;
		this.person=person;
		}
	
	public abstract void deposit(double sum);
		
	
	public abstract void withdrawal(double sum);
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
		setChanged();
		notifyObservers(person+" Account "+this.getId()+" sum changed to: "+money);
	}
	
	public int getId() {
		return id;
	}
	public String getTip() {
		return tip;
	}
	public void setId(int id) {
		this.id = id;
		setChanged();
		notifyObservers(person+", Account's "+this.getId()+" id changed to: "+id);
	}
	public void setTip(String tip) {
		this.tip = tip;
		setChanged();
		notifyObservers(person+", Account's "+this.getId()+" type changed to: "+tip);
	}
	public String getIdPerson() {
		return person;
	}
	public void setIdPerson(String person) {
		this.person = person;
		setChanged();
		notifyObservers(person+", Account's "+this.getId()+" holder changed to: "+person);
	}
	public abstract String toStringDeposit();
		
	
	public abstract String toStringWithdrawal(); 
		//return "\nIt was made a withdrawal from holder's \n"+this.getIdPerson()+" account "+this.getId()+". Current sum: "+this.getMoney();
	
	
	

}
