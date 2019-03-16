package tema2;

public class Client implements Comparable<Object> {
	private int timpSosire;
	private int timpServire;
	private  int idClient;
    private static int id=0;
	
	public Client(int timpSosire,int timpServire) {
		this.timpServire=timpServire;
		this.timpSosire=timpSosire;		
		id++;
		this.idClient=id;
		
}
	public int getTimpServire() {
		return timpServire;
	}
	public int getTimpSosire() {
		return timpSosire;
	}
	public void setTimpServire(int timpServire) {
		this.timpServire = timpServire;
	}
	public void setTimpSosire(int timpSosire) {
		this.timpSosire = timpSosire;
	}
    public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	@Override
	public int compareTo(Object o) {
		return Integer.compare(this.timpSosire, ((Client)o).timpSosire);
	}

}
