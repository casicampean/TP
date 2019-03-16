package tema1;

import java.util.ArrayList;
import java.util.Collections;


public class Polinom {
	private ArrayList<Monom> polinom=new ArrayList<>();

	public ArrayList<Monom> getPolinom() {
		return polinom;
	}

	public void setPolinom(ArrayList<Monom> monoame) {
		this.polinom = monoame;
	}
	public void adaugareMonom(Monom m) {
		polinom.add(m);
	}
	public void eliminaMonom(Monom m) {
		polinom.remove(m);
	}
	public void reverseSort() {
		Collections.sort(polinom, Collections.reverseOrder());
	}
	
		
	

  

	
	

}
