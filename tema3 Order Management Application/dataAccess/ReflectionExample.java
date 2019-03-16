package dataAccess;
/**
 * 
 * @author Casi
 * 
 *
 */
import java.lang.reflect.Field;
import java.util.ArrayList;


import javax.swing.JTable;


public class ReflectionExample {
	/**
	 * @param object reprezinta o lista de obiecte
	 * aceasta va fii folosita in interfata, acolo va lua 
	 * o lista de obiecte de tip claselor din pachetul model
	 * @param c int c reprezinta numarul coloanelor
	 * @return returneaza un JTable construit in functie
	 */
	public static JTable retrieveProperties(ArrayList<?> object,int c) {
		ArrayList<String>rows=new ArrayList<String>();
		Object[]columns=new Object[c];
		
		int i=0,p=0;
		
        for (Object ob: object) {
        	int ii=ob.getClass().getDeclaredFields().length;	
		for (Field field : ob.getClass().getDeclaredFields()) {
			field.setAccessible(true); 
			Object value;
			try {
				value = field.get(ob);
				if( i <= ii-1)
				{
				columns[i++]=field.getName();
				}
				rows.add(value.toString());

			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
        }
        Object [][]rand= new Object[object.size()][i];
        for(int q = 0; q < object.size(); q++) {
        	for(int w = 0 ;w < i; w++) {
        	if(p < rows.size())
        	rand[q][w]=rows.get(p);
        	p++;
        	}
       }
        
        JTable table=new JTable(rand,columns);
        return table;
	}
}
