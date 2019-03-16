package tema1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOperatii {
	Polinom p1=new Polinom();
	Polinom p2=new Polinom();
	Polinom p3=new Polinom();
	Operatii op=new Operatii();
	
	@BeforeEach
	void setUp() throws Exception {
		p1=Interfata.citirePolinom("5x^4+5x^3+2");
		p2=Interfata.citirePolinom("x^2+1");		
	}

	@Test
	void testAdunare() {
		String result="";
		p3=op.adunare(p1,p2);
		p3.reverseSort();
		for(Monom m:p3.getPolinom()) {
			result=result+m.toString();
		}
		assertEquals("+5x^4+5x^3+x^2+3",result);
	}
	@Test
	void testScadere() {
		String result="";
		p3=op.scadere(p1,p2);
		p3.reverseSort();
		for(Monom m:p3.getPolinom()) {
			result=result+m.toString();
		}
		assertEquals("+5x^4+5x^3-x^2+1",result);
	}
	@Test
	void testInmultire() {
		String result="";
		p3=op.inmultire(p1,p2);
		p3.reverseSort();
		for(Monom m:p3.getPolinom()) {
			result=result+m.toString();
		}
		assertEquals("+5x^6+5x^5+5x^4+5x^3+2x^2+2",result);
	}
	@Test
	void testImpartire() {
		String result="";
		p3=op.impartire(p1,p2);
		p3.reverseSort();
		for(Monom m:p3.getPolinom()) {
			result=result+m.toString();
		}
		assertEquals("+5x^2+5x-5",result);
	}
	@Test
	void testDerivare() {
		String result="";
		p3=op.derivare(p1);
		p3.reverseSort();
		for(Monom m:p3.getPolinom()) {
			result=result+m.toString();
		}
		assertEquals("+20x^3+15x^2",result);
	}
	@Test
	void testIntegrare() {
		String result="";
		p3=op.integrare(p1);
		p3.reverseSort();
		for(Monom m:p3.getPolinom()) {
			result=result+m.toStringIntegrare();
		}
		assertEquals("+5x^5/5+5x^4/4+2x",result);
	}

}
