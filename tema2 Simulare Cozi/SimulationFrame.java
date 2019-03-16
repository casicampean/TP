package tema2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimulationFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p1, p2, p3, p4, p5, p6,p7;
	private JTextField tVMin,tVMax,tSMin,tSMax,nrQ,timeLimit,nrClients;
	private JLabel iArrival,iServing,nCozi,simInterval,linie,linie2,nClients;
	private JButton butonStart;
	private JScrollPane scroll1; 
	private JTextArea logger,QEvolution;

	public SimulationFrame() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		} );
		this.setSize(600, 700);
		this.setVisible(true);
		this.setLayout(new GridLayout(7,1));
		
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.add(p4);
		this.add(p5);
		this.add(p6);
		this.add(p7);
		
		
		
		butonStart=new JButton("Start");
		
		tVMin=new JTextField(3);
		tVMax=new JTextField(3);
		tSMin=new JTextField(3);
		tSMax=new JTextField(3);
		nrQ=new JTextField(3);
		timeLimit=new JTextField(3);
		nrClients=new JTextField(3);
		
		iArrival=new JLabel("Interval timp sosire:");
		iServing=new JLabel("Interval timp servire:");
		nCozi=new JLabel("Numar cozi:");
		simInterval=new JLabel("Timp simulare:");
		linie=new JLabel("-");
		linie2=new JLabel("-");
		nClients=new JLabel("Numar Clienti:");
		
		logger=new JTextArea("",5,30);
		QEvolution=new JTextArea("",6,30);
		scroll1=new JScrollPane();
		scroll1.setViewportView(logger);
		
		//interval sosire
		p1.add(iArrival);
		p1.add(tVMin);
		p1.add(linie2);
		p1.add(tVMax);
		//interval servire
		p2.add(iServing);
		p2.add(tSMin);
		p2.add(linie);
		p2.add(tSMax);
		//nr cozi
		p3.add(nCozi);
		p3.add(nrQ);
		p3.add(nClients);
		p3.add(nrClients);
		//interval simulare
		p4.add(simInterval);
		p4.add(timeLimit);
		//logger
		p5.add(scroll1);
		//queue evolution
		p6.add(QEvolution);
		//start buton
		p7.add(butonStart);
		
		p1.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
		p2.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
		p3.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
		p4.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
		p5.setLayout(new FlowLayout(FlowLayout.CENTER,1,1));
		p6.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
		p7.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
		
		p1.setBackground(new Color(35, 2, 49));
		p2.setBackground(new Color(35, 2, 49));
		p3.setBackground(new Color(35, 2, 49));
		p4.setBackground(new Color(35, 2, 49));
		p5.setBackground(new Color(35, 2, 49));
		p6.setBackground(new Color(35, 2, 49));
		p7.setBackground(new Color(35, 2, 49));
		
		iArrival.setForeground(new Color(249, 217, 122));
		iServing.setForeground(new Color(249, 217, 122));
		linie.setForeground(new Color(249, 217, 122));
		linie2.setForeground(new Color(249, 217, 122));
		nCozi.setForeground(new Color(249, 217, 122));
		simInterval.setForeground(new Color(249, 217, 122));
		nClients.setForeground(new Color(249, 217, 122));
		
		
		butonStart.setBackground(new Color(249, 217, 122));
		butonStart.setVisible(true);
		
		iArrival.setVisible(true);
		tVMin.setVisible(true);
		linie2.setVisible(true);
		tVMax.setVisible(true);
		
		iServing.setVisible(true);
		tSMin.setVisible(true);
		linie.setVisible(true);
		tSMax.setVisible(true);
		
		nCozi.setVisible(true);
		nrQ.setVisible(true);
		nrClients.setVisible(true);
		nClients.setVisible(true);
		
		simInterval.setVisible(true);
		timeLimit.setVisible(true);
		
		logger.setVisible(true);
		
		QEvolution.setVisible(true);
		
		p1.setVisible(true);
		p2.setVisible(true);
		p3.setVisible(true);
		p4.setVisible(true);
		p5.setVisible(true);
		p6.setVisible(true);
		p7.setVisible(true);
		
		butonStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int minArrivalTime=Integer.parseInt(tVMin.getText());
				int maxArrivalTime=Integer.parseInt(tVMax.getText());
				int minServingTime=Integer.parseInt(tSMin.getText());
				int maxServingTime=Integer.parseInt(tSMax.getText());
				int nrCozi=Integer.parseInt(nrQ.getText());
				int simTime=Integer.parseInt(timeLimit.getText());
				int nClienti=Integer.parseInt(nrClients.getText());
				Simulation s=new Simulation(simTime,minArrivalTime,maxArrivalTime,minServingTime,maxServingTime,nClienti,nrCozi);
				Thread t=new Thread(s);
				t.start();
				dispose();
				
				
			}
		});
		
		
		
		
		

	}
	public void toStringLogger(String s) {
		logger.append(s);
		
	}
	
	public void toStringQEvolution(String s) {
		QEvolution.append(s);
		
	}
	public void toStringCoada() {
		QEvolution.setText("");
		
	}
	public static void main(String[] args) {
		//Simulation ss=new Simulation();
		SimulationFrame f=new SimulationFrame();
	}
	

	
	
	

}
