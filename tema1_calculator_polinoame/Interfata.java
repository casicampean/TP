package tema1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Interfata {
	
	static JFrame frame;
	static JLabel p1, p2, p3;
	static JButton butonAdunare, butonScadere, butonInmultire;
	static JButton butonImpartire, butonDerivare, butonIntegrare, butonOk;
	static JTextField polinom1, polinom2, polinomRez;
	static JPanel panel1,panel2, panel3, panel4;
	
	public static void initInterfata() {
	    frame=new JFrame("Tema 1");
	    frame.setResizable(false);
	    panel1=new JPanel();
	    panel2=new JPanel();
	    panel3=new JPanel();
	    panel4=new JPanel();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		} );
	frame.setSize(600,400);
	frame.setVisible(true);
	frame.setLayout(new GridLayout(4, 1));
	
	frame.add(panel1);
	frame.add(panel2);
	frame.add(panel3);
	frame.add(panel4);
	
	butonAdunare=new JButton("+");
	butonScadere=new JButton("-");
	butonInmultire=new JButton("*");
	butonImpartire=new JButton("/");
	butonDerivare=new JButton("'");
	butonIntegrare=new JButton("I");
	butonOk=new JButton("OK");
	
	polinom1=new JTextField(30);
	polinom2=new JTextField(30);
	polinomRez=new JTextField(30);
	
	p1=new JLabel("Polinom 1:");
	p2=new JLabel("Polinom 2:");
	p3=new JLabel("Rezultat:");
	
	//primul polinom
	panel1.add(p1);
	panel1.add(polinom1);
		
	//al 2-lea polinom
	panel2.add(p2);
	panel2.add(polinom2);
		
	//butoane
	panel3.add(butonAdunare);
	panel3.add(butonScadere);
	panel3.add(butonInmultire);
	panel3.add(butonImpartire);
	panel3.add(butonDerivare);
	panel3.add(butonIntegrare);
	panel3.add(butonOk);
		
	//Polinom rezultat
	panel4.add(p3);
	panel4.add(polinomRez);
	
	butonAdunare.setPreferredSize(new Dimension(50, 50));
	butonScadere.setPreferredSize(new Dimension(50, 50));
	butonInmultire.setPreferredSize(new Dimension(50, 50));
	butonImpartire.setPreferredSize(new Dimension(50, 50));
	butonDerivare.setPreferredSize(new Dimension(50, 50));
	butonIntegrare.setPreferredSize(new Dimension(50, 50));
	butonOk.setPreferredSize(new Dimension(50, 50));
	
	butonAdunare.setBackground(new Color(249, 217, 122));
	butonScadere.setBackground(new Color(249, 217, 122));
	butonInmultire.setBackground(new Color(249, 217, 122));
	butonImpartire.setBackground(new Color(249, 217, 122));
	butonDerivare.setBackground(new Color(249, 217, 122));
	butonIntegrare.setBackground(new Color(249, 217, 122));
	butonOk.setBackground(new Color(249, 217, 122));
	
	butonAdunare.setFont(new Font("Arial", Font.PLAIN, 20));
	butonScadere.setFont(new Font("Arial", Font.PLAIN, 20));
	butonInmultire.setFont(new Font("Arial", Font.PLAIN, 20));
	butonImpartire.setFont(new Font("Arial", Font.PLAIN, 20));
	butonDerivare.setFont(new Font("Arial", Font.PLAIN, 20));
	butonIntegrare.setFont(new Font("Arial", Font.PLAIN, 20));
	butonOk.setFont(new Font("Arial", Font.PLAIN, 20));
	
	butonAdunare.setBorder(new LineBorder(Color.WHITE));
	butonScadere.setBorder(new LineBorder(Color.WHITE));
	butonInmultire.setBorder(new LineBorder(Color.WHITE));
	butonImpartire.setBorder(new LineBorder(Color.WHITE));
	butonDerivare.setBorder(new LineBorder(Color.WHITE));
	butonIntegrare.setBorder(new LineBorder(Color.WHITE));
	butonOk.setBorder(new LineBorder(Color.WHITE));
	
	p1.setFont(new Font("Serif", Font.BOLD, 25));
	p2.setFont(new Font("Serif", Font.BOLD, 25));
	p3.setFont(new Font("Serif", Font.BOLD, 25));
	
	p1.setForeground(new Color(249, 217, 122));
	p2.setForeground(new Color(249, 217, 122));
	p3.setForeground(new Color(249, 217, 122));

	panel1.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
	panel2.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
	panel3.setLayout(new FlowLayout(FlowLayout.CENTER,20,30));
	panel4.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
	
	panel1.setBackground(new Color(35, 2, 49));
	panel2.setBackground(new Color(35, 2, 49));
	panel3.setBackground(new Color(35, 2, 49));
	panel4.setBackground(new Color(35, 2, 49));

	butonAdunare.setVisible(true);
	butonScadere.setVisible(true);
	butonInmultire.setVisible(true);
	butonImpartire.setVisible(true);
	butonDerivare.setVisible(true);
	butonIntegrare.setVisible(true);
	butonOk.setVisible(true);
	

	polinom1.setVisible(true);
	polinom2.setVisible(true);
	polinomRez.setVisible(true);
	
	p1.setVisible(true);
	p2.setVisible(true);
	p3.setVisible(true);
	
	panel1.setVisible(true);
	panel2.setVisible(true);
	panel3.setVisible(true);
	panel4.setVisible(true);

		butonAdunare.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Polinom pol1=new Polinom();
			Polinom pol2=new Polinom();
			Polinom polRez=new Polinom();
			Operatii op=new Operatii();
			String rez = "";
			pol1=citirePolinom(polinom1.getText());
			pol2=citirePolinom(polinom2.getText());
			polRez=op.adunare(pol1,pol2);
			polRez.reverseSort();
			for(Monom m:polRez.getPolinom()) {
				rez=rez+m.toString();
			}
			polinomRez.setText(rez);
		}
	});
	butonScadere.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Polinom pol1=new Polinom();
			Polinom pol2=new Polinom();
			Polinom polRez=new Polinom();
			Operatii op=new Operatii();
			String rez = "";
			pol1=citirePolinom(polinom1.getText());
			pol2=citirePolinom(polinom2.getText());
			if(polinom1.getText().equals(polinom2.getText())) {
				polinomRez.setText("0");
			}
			else
			{
			polRez=op.scadere(pol1,pol2);
			polRez.reverseSort();
			for(Monom m:polRez.getPolinom()) {
				rez=rez+m.toString();
			}
			polinomRez.setText(rez);
			}
		}
	});
	butonInmultire.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Polinom pol1=new Polinom();
			Polinom pol2=new Polinom();
			Polinom polRez=new Polinom();
			Operatii op=new Operatii();
			String rez = "";
			pol1=citirePolinom(polinom1.getText());
			pol2=citirePolinom(polinom2.getText());
			if(polinom1.getText().equals("0") || polinom2.getText().equals("0")) {
				polinomRez.setText("0");
			}
			else
			{
			polRez=op.inmultire(pol1,pol2);
			polRez.reverseSort();
			for(Monom m:polRez.getPolinom()) {
				rez=rez+m.toString();
			}
			polinomRez.setText(rez);
			}
		}
	});
	butonImpartire.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Polinom pol1=new Polinom();
		Polinom pol2=new Polinom();
		Polinom polRez=new Polinom();
		Operatii op=new Operatii();
		String rez = "";
		pol1=citirePolinom(polinom1.getText());
		pol2=citirePolinom(polinom2.getText());
		if(polinom1.getText().equals("0")) {
			polinomRez.setText("0");
		}
		else if(polinom2.getText().equals("0")){
			polinomRez.setText("Eroare impartire la zero!");
		}
		else
		{
		polRez=op.impartire(pol1,pol2);
		polRez.reverseSort();
		for(Monom m:polRez.getPolinom()) {
			rez=rez+m.toString();
		}
		polinomRez.setText(rez);
		}
	}
});
	butonOk.addActionListener(new ActionListener() {
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		polinom1.setText("");
		polinom2.setText("");
		polinomRez.setText("");
		
	}
});
	butonDerivare.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Polinom pol1=new Polinom();
		Polinom polRez=new Polinom();
		Operatii op=new Operatii();
		String rez = "";
		pol1=citirePolinom(polinom1.getText());
		if(pol1.getPolinom().get(0).getPutere() == 0) {
			rez="0";
		}
		else {
		polRez=op.derivare(pol1);
		polRez.reverseSort();
		for(Monom m:polRez.getPolinom()) {
			rez=rez+m.toString();
			}
		}
		polinomRez.setText(rez);
	}
});
	butonIntegrare.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Polinom pol1=new Polinom();
		Polinom polRez=new Polinom();
		Operatii op=new Operatii();
		String rez = "";
		pol1=citirePolinom(polinom1.getText());
		polRez=op.integrare(pol1);
		polRez.reverseSort();

		for(Monom m:polRez.getPolinom()) {
			rez=rez+m.toStringIntegrare();
		}
		polinomRez.setText(rez);
	}
});
	

		
	}
	public static Polinom citirePolinom(String s){
		Polinom p=new Polinom();
		String Regex = "((-?\\d+(?=x))?(-?[xX])(\\^(-?\\d+))?)|(-?\\d+)";
		Pattern pattern = Pattern.compile(Regex);
		String input = s;
		Matcher matcher = pattern.matcher(input);
		//group(1) = ((-?\\d+(?=x)) ->existenta unui termen valid
		//group(2) = (?=x) ->valoarea coeficientului
		//group(3) = (-?[xX]) ->existenta lui x
		//group(4) = (\\^(-?\\d+)) ->existenta unei puteri
		//group(5) = (-?\\d+) ->valoarea puterii
		//group(6) = (-?\\d+) ->valoarea coeficientului lui x^0
		
       // if(matcher.find() == false) {
       // 	p.adaugareMonom(new Monom(0,-1));
       // }
       // else
       // {
		
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
		
		initInterfata();
	}
}
