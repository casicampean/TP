package tema1;

public class Monom implements Comparable<Object>{
	private int coeficient;
	private int putere;
	
	public Monom(int coeficient,int putere) {
		this.coeficient=coeficient;
		this.putere=putere;
	}
	public int getCoeficient() {
		return coeficient;
	}
	public void setCoeficient(int coeficient) {
		this.coeficient = coeficient;
	}
	public int getPutere() {
		return putere;
	}
	public void setPutere(int putere) {
		this.putere = putere;
	}

	@Override
	public int compareTo(Object o) {
		return Integer.compare(this.putere, ((Monom)o).putere);
	}
	
	public String toString() {
		if(putere > 1) {
			if(coeficient > 1) {
				return "+" + coeficient + "x^" + putere;
			}
			if(coeficient == 1) {
				return "+" +  "x^" + putere;
			}
			if(coeficient == -1) {
				return "-x^" + putere;
			}
			if(coeficient <= -1) {
				return coeficient + "x^" + putere;
			}
		}
		if(putere == 1) {
			if(coeficient > 1) {
				return "+" + coeficient + "x";
			}
			if(coeficient == 1) {
				return "+x";
			}
			if(coeficient== -1) {
				return "-x";
			}
			if(coeficient < -1) {
				return  coeficient + "x";
			}		
		}
		if(putere == 0 && coeficient > 0) {
			return "+"+coeficient;
		}
		if(putere == 0 && coeficient < 0) {
				return ""+coeficient;
		}
		
		if(coeficient == 0 && putere == 0) {
			return "";
		}
		if( coeficient == 0 ) {
			return "";
		}
		return "";
	}
	public String toStringIntegrare() {
		if(putere > 1) {
			if(coeficient > 1) {
				return "+" + coeficient +  "x^" + putere +"/"+ putere;
			}
			if(coeficient == 1) {
				return "+" +  "x^" + putere +"/"+ putere;
			}
			if(coeficient == -1) {
				return "+" + "x^" + putere +"/"+ putere;
			}
			if(coeficient < -1) {
				return coeficient + "x^" + putere +"/"+ putere;
			}
		}
		if(putere == 1) {
			if(coeficient > 1) {
				return "+" + coeficient + "x";
			}
			if(coeficient == 1) {
				return "+x";
			}
			if(coeficient== -1) {
				return "-x";
			}
			if(coeficient < -1) {
				return  coeficient + "x";
			}		
		}
		return "";
		
	}
	

}
