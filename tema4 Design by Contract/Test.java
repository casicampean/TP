package tema4;

import static org.junit.jupiter.api.Assertions.*;


class Test {
	Bank bb=new Bank();
	Person p1=new Person("15432","ccc");
	
	SavingAccount a1=new SavingAccount(321,450,"ccc");
	
	/*bb.addPerson(p);
	bb.addPerson(pp);
	bb.addPerson(ss);
	bb.addAccount(p, aa);
	bb.addAccount(pp, aaa);
	bb.addAccount(p, aa2);
	bb.addAccount(ss, aa3);
	bb.addAccount(ss, aa4);*/

	@org.junit.jupiter.api.Test
	void testAddPerson() {
		bb.addPerson(p1);
		assertEquals(bb.getHolder().size(),1);
	}
	@org.junit.jupiter.api.Test
	void testRemovePerson() {
		bb.addPerson(p1);
		bb.removePerson(p1);
		assertEquals(bb.getHolder().size(),0);
	}
	@org.junit.jupiter.api.Test
	void testAddAccount() {
		bb.addPerson(p1);
		bb.addAccount(p1, a1);
		assertEquals(bb.getHolder().get(p1).size(),1);
	}
	@org.junit.jupiter.api.Test
	void testRemoveAccount() {
		bb.addPerson(p1);
		bb.addAccount(p1, a1);
		bb.removeAccount(p1, a1);
		assertEquals(bb.getHolder().get(p1).size(),0);
	}
	
	
	

}
