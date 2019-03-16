package tema4;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class Person implements java.io.Serializable, Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String cnp;
	public Person(String cnp, String name) {
		this.name=name;
		this.cnp=cnp;
	}
	public String getId() {
		return cnp;
	}
	public void setId(String id) {
		this.cnp = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println((String)arg);
		
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) return false;
	    if (!(obj instanceof Person))
	        return false;
	    if (obj == this)
	        return true;
	    return this.getId() == ((Person) obj).getId();
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int result=1;
		result=31*result+((cnp == null) ? 0 : cnp.hashCode());
		return result;
	}
	
	
	

}
