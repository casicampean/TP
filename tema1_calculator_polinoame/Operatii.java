package tema1;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatii {
	public Polinom adunare(Polinom p1, Polinom p2) {
		Polinom pRez=new Polinom();
		for(int i=0; i < p1.getPolinom().size(); i++) {
			for(int j=0; j < p2.getPolinom().size(); j++) {
				if(p1.getPolinom().get(i).getPutere() == p2.getPolinom().get(j).getPutere()) {
					p1.getPolinom().get(i).setCoeficient(p1.getPolinom().get(i).getCoeficient()+p2.getPolinom().get(j).getCoeficient());
				    p2.getPolinom().remove(j);
				}
			}
			pRez.adaugareMonom(p1.getPolinom().get(i));
		}
			for(Monom m:p2.getPolinom()) {		
			pRez.adaugareMonom(m);
			}
		return pRez;
	}
	public Polinom scadere(Polinom p1, Polinom p2) {
		Polinom pRez=new Polinom();
		for(int i=0; i < p1.getPolinom().size(); i++) {
			for(int j=0; j < p2.getPolinom().size(); j++) {
				if(p1.getPolinom().get(i).getPutere() == p2.getPolinom().get(j).getPutere()) {
					p1.getPolinom().get(i).setCoeficient(p1.getPolinom().get(i).getCoeficient()-p2.getPolinom().get(j).getCoeficient());
				    p2.eliminaMonom(p2.getPolinom().get(j));
				    
				}
				
			}
			pRez.adaugareMonom(p1.getPolinom().get(i));
		}
		for(Monom m:p2.getPolinom()) {
			m.setCoeficient(m.getCoeficient() * (-1));											
			pRez.adaugareMonom(m);
			}
		return pRez;
	}
	public Polinom inmultire(Polinom p1, Polinom p2) {
		Polinom pRez=new Polinom();
		Monom m;
		for(Monom m1:p1.getPolinom()) {
			for(Monom m2:p2.getPolinom()) {
				m=new Monom(m1.getCoeficient() * m2.getCoeficient(),m1.getPutere()+m2.getPutere());
				pRez.adaugareMonom(m);
			}
		}
		for(int i=0; i < pRez.getPolinom().size() - 1; i++) {
			for(int j=i+1; j < pRez.getPolinom().size(); j++) {
				if(pRez.getPolinom().get(i).getPutere() == pRez.getPolinom().get(j).getPutere()) {
					pRez.getPolinom().get(i).setCoeficient(pRez.getPolinom().get(i).getCoeficient()+pRez.getPolinom().get(j).getCoeficient());
					pRez.getPolinom().remove(j);
				}
			}
			
		}
		return pRez;		
	}
	public Polinom impartire(Polinom p1, Polinom p2) {
		Polinom pRez=new Polinom();
		pRez.adaugareMonom(new Monom(0,0));
		Polinom p3=new Polinom();
		Polinom p4=new Polinom();
		Operatii o=new Operatii();
		Polinom rest=p1;
		int i=0, j=rest.getPolinom().size();
		for( i = 0; i < j; i++) {
		if(rest.getPolinom().get(i).getCoeficient() != 0 && rest.getPolinom().get(i).getPutere() >= pRez.getPolinom().get(0).getPutere()) {
			p4.adaugareMonom(new Monom(rest.getPolinom().get(i).getCoeficient()/p2.getPolinom().get(0).getCoeficient(), rest.getPolinom().get(i).getPutere()-p2.getPolinom().get(0).getPutere()));
			pRez=o.adunare(pRez, p4);
			p3=o.inmultire(p4,p2);
			p3.reverseSort();
			rest=o.scadere(rest, p3);
			rest.reverseSort();
			pRez.reverseSort();
			p4.getPolinom().clear();
		}
		}
		return pRez;
	}
	
	public Polinom derivare(Polinom p) {
		Polinom pRez=new Polinom();
		for(Monom m:p.getPolinom()) {
			m.setCoeficient(m.getCoeficient() * m.getPutere());
			m.setPutere(m.getPutere() - 1);
			pRez.adaugareMonom(m);
		}
		
		return pRez;
	}
	
	public Polinom integrare(Polinom p) {
		Polinom pRez=new Polinom();
		for(Monom m:p.getPolinom()) {
			//m.setCoeficient(m.getCoeficient() / (m.getPutere() + 1));
			m.setPutere(m.getPutere() + 1);
			pRez.adaugareMonom(m);
		}
		return pRez;
	}
	
	public static Polinom citirePolinom2(String s){
		Polinom p=new Polinom();
		String Regex = "((-?\\d+(?=x))?(-?[xX])(\\^(-?\\d+))?)|(-?\\d+)";
		Pattern pattern = Pattern.compile(Regex);
		//String input = "2x^3-5x^3-x^2+x^2+10x-11x-x+x+5";
		String input = s;
		Matcher matcher = pattern.matcher(input);
		//group(1) = ((-?\\d+(?=x)) ->existenta unui termen valid
		//group(2) = (?=x) ->valoarea coeficientului
		//group(3) = (-?[xX]) ->existenta lui x
		//group(4) = (\\^(-?\\d+)) ->existenta unei puteri
		//group(5) = (-?\\d+) ->valoarea puterii
		//group(6) = (-?\\d+) ->valoarea coeficientului lui x^0
		

		while (matcher.find()) {
			int coeficient=0, putere=0;
		    //CAZUL 1: 2x^3, -2x^3 ;coeficient = group(2) , putere = group(5);
		    if ( matcher.group(2) != null && matcher.group(6) == null && matcher.group(5) != null) {
		         coeficient=Integer.parseInt(matcher.group(2));
		    	 putere=Integer.parseInt(matcher.group(5));
		    }
		    
		    //CAZUL 2: x^2, -x^2 ; coeficient = 1 / -1 , putere = group(5);
		    if (matcher.group(1) != null && matcher.group(2) == null && matcher.group(3) != null && matcher.group(4) != null && matcher.group(5) != null) {
		    	if(matcher.group(3).equals("-x")) {
		    		coeficient=-1;
		    	}
		        if(matcher.group(3).equals("x")) {
		    	    coeficient=1;
		    	} 
		        putere=Integer.parseInt(matcher.group(5));
		    }
		    
		    //CAZUL 3: 2x, -2x ; coeficient = group(2), putere = 1;
		    if (matcher.group(2) != null && matcher.group(4) == null && matcher.group(6) == null) {
		    	coeficient=Integer.parseInt(matcher.group(2));
		    	putere=1;
		    }
		    
		    //CAZUL 4: x, -x ; coeficient = 1 / -1, putere = 1;
		    if (matcher.group(2) == null && matcher.group(5) == null && matcher.group(6) == null) {
		    	if(matcher.group(1).equals("-x")) {
		    		coeficient=-1;
		    	}
		        if(matcher.group(1).equals("x")) {
		    	    coeficient=1;
		    	}
		         putere=1;
		    }
		    //CAZUL 5: 2, -2 ; coeficient = group(6), putere = 0;
		    if (matcher.group(6) != null) {
		    	 coeficient=Integer.parseInt(matcher.group(6));
		    	 putere=0;
		    }
		   Monom m=new Monom(coeficient, putere);
		   p.adaugareMonom(m);
		}
		
		return p;
	}
	 
	public static void main(String[] args) {


		
		Polinom p1=new Polinom();
		Polinom p2=new Polinom();
		Polinom p3=new Polinom();
		Operatii op=new Operatii();
		p1=citirePolinom2("5x^4+5x^3+2");
		p2=citirePolinom2("x^2+1");
		
		p3=op.adunare(p1,p2);
		p3.reverseSort();
		for(Monom m:p3.getPolinom()) {
			System.out.print(m.toString());
		}
		
		
		//+20x^3+15x^2

		//String Regex = "((-?\\d+(?=x))?(-?[xX])(\\^(-?\\d+))?)|(-?\\d+)";
		//Pattern pattern = Pattern.compile(Regex);
		//String input = "cccX";


		//Matcher matcher = pattern.matcher(input);
		
		//System.out.println(matcher.find());
		
		
	}

}
