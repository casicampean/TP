package tema4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Bank implements BankProc, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap<Person, ArrayList<Account>> holder=new HashMap<>();

	@Override
	public void addPerson(Person p) {
		assert p != null;
		int sizePre=holder.size();
		holder.put(p,new ArrayList<>());
		
		int sizePost=holder.size();
		assert sizePost == sizePre+1;
		assert holder.containsKey(p);
		
		
	}

	@Override
	public void removePerson(Person p) {
		assert holder.size() > 0;
		assert p != null;
		int sizePre=holder.size();
		holder.remove(p);
		int sizePost=holder.size();
		assert sizePost == sizePre-1;
		
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void addAccount(Person p, Account a) {
		assert p != null;
		assert a != null;
		int sizePre=holder.get(p).size();
		holder.get(p).add(a);
		a.addObserver(p);
		int sizePost=holder.get(p).size();
		assert sizePost == sizePre+1;
		assert holder.get(p).contains(a);
		
	}
	
	@Override
	public void removeAccount(Person p, Account a) {
		assert p != null;
		assert a != null;
		assert holder.get(p).size() > 0;
		int sizePre=holder.get(p).size();
		holder.get(p).remove(a);
		int sizePost=holder.get(p).size();
		assert sizePost == sizePre-1;
		
	}
	
	@SuppressWarnings("deprecation")
	public void initializeObservers() {
		for(Person p: holder.keySet()) {
			for(Account a: holder.get(p)) {
				a.addObserver(p);
			}
		}
	}

	
	
	public HashMap<Person, ArrayList<Account>> getHolder() {
		return holder;
	}
	
	public void serialization(Bank b)  {
		try {
			//Bank b=new Bank();
	         FileOutputStream fileOut =
	         new FileOutputStream("C:\\\\Users\\Horea\\\\eclipse-workspace\\\\tema4\\\\bank.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(b);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public Bank deserialization() {
		Bank b=null;
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream("C:\\Users\\Horea\\eclipse-workspace\\tema4\\bank.ser");
			ObjectInputStream in= new  ObjectInputStream(fileIn);
			b=(Bank) in.readObject();
			in.close();
			fileIn.close();
		 } catch (IOException i) {
	         i.printStackTrace();
	         //return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         //return;
	      }	
		return b;
	}
	public static void main(String[] args) {
		Bank bb=new Bank();
		Person p=new Person("12345","ana");
		Person pp=new Person("12340","anna");
		Person ss=new Person("12343","ss");
		SavingAccount aa=new SavingAccount(101,200,"ana");
		SavingAccount aaa=new SavingAccount(333,500,"anna");
		SavingAccount aa2=new SavingAccount(149,5500,"ana");
		SavingAccount aa3=new SavingAccount(123,500,"ss");
		SpendingAccount aa4=new SpendingAccount(125,700,"ss");
		bb.addPerson(p);
		bb.addPerson(pp);
		bb.addPerson(ss);
		bb.addAccount(p, aa);
		bb.addAccount(pp, aaa);
		bb.addAccount(p, aa2);
		bb.addAccount(ss, aa3);
		bb.addAccount(ss, aa4);
		
		
		
		
		
		
		
		
		//bb.removeAccount(pp, aaa);
		bb.serialization(bb);
		
		//bb.removeAccount(ss, aa4);
		
		
		bb=bb.deserialization();
		/*for(Person p:bb.getHolder().keySet()) {
			if(p.getName().equals("ss")) {
				//System.out.println(tip);
				//SavingAccount s=new SavingAccount(id,sum,idP);
				//b.addAccount(p, s);
				//System.out.println(p.getName());
			}
		}*/
		//SavingAccount aa3=new SavingAccount(123,500,"ss");
		
		
		//bb.addAccount(p, a);
		
		//System.out.println(total);
		//System.out.println(total);
		//aa.setTip("Spending");
		aa.withdrawal(30);
		aa.withdrawal(30);
		
		System.out.println(aa.isActionWithdrawal());
		for ( Person key : bb.getHolder().keySet() ) {
		    System.out.println( key.getName() );
		    if(bb.getHolder().get(key)!=null) {
		    for (Account a:bb.getHolder().get(key))
				System.out.println(a.getId() +" "+a.getMoney());
		    }
		}
		
	}
	
	

}
