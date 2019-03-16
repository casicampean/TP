package tema4;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;







public class Interface {
	static JFrame frame;
	static JTable cTable,tTable;
	static JButton addC,delC,addA,delA,readC,readA,clientB,accB,addWdrawB,deposit,done,withdraw;
	static JButton doneC,insertC,deleteC,updateC,showC,doneA,insertA,deleteA,updateA,showA;
	static JTextField idCText,nameCText,idAText,typeAText,totalAText,idPersonText,idPText,idAccText,sumText;
	static JPanel cPanel,aPanel, addWdraw,menuPanel;
	static JLabel idC,nameC,idT,nameT,priceT,idPersonT,idP,idAcc,sum;
	static JTextArea operation;
	
	public static void initInterface() {
		frame=new JFrame("tema4");
		cPanel=new JPanel();
		aPanel=new JPanel();
		addWdraw=new JPanel();
		menuPanel=new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600,400);
	    frame.setVisible(true);
	    frame.getContentPane().setLayout(new CardLayout(0,0));
		
	    
	    //Menu Panel
	    frame.getContentPane().add(menuPanel);
	    menuPanel.setLayout(null);
	    
	    clientB=new JButton("Clients Operations");
	    accB=new JButton("Accounts Operations");
	    addWdrawB=new JButton("Add / Withdrawal");
	    
	    clientB.setBounds(170, 40, 170, 50);
	    accB.setBounds(170, 120, 170, 50);
	    addWdrawB.setBounds(170, 200, 170, 50);
	    
	    menuPanel.add(clientB);
	    menuPanel.add(accB);
	    menuPanel.add(addWdrawB);
	    
	    menuPanel.setVisible(true);
	    
	    //Client Panel
	    frame.getContentPane().add(cPanel);
	    cPanel.setLayout(new GridLayout(3,2));
	    cPanel.setLayout(null);
	    
	    idC=new JLabel("Id Person:");
	    idC.setBounds(100, 30, 90, 40);
	    nameC=new JLabel("Name:");
	    nameC.setBounds(100, 70, 90, 40);
	    cTable=new JTable();
	    idCText=new JTextField(15);
	    idCText.setBounds(195, 40, 60, 20);
	    nameCText=new JTextField(15);
	    nameCText.setBounds(195, 80, 60, 20);
	    doneC=new JButton("Done");
	    //JScrollPane scrC=new JScrollPane(cTable);
	    //scrC.setBounds(280, 40, 300, 150);
	    doneC.setBounds(140, 215, 80, 40);
	    insertC=new JButton("Insert");
	    deleteC=new JButton("Delete");
	    updateC=new JButton("Update");
	    showC=new JButton("View all");
	    insertC.setBounds(100, 110, 80, 40);
	    deleteC.setBounds(185, 110 , 80, 40);
	    updateC.setBounds(100, 165, 80, 40);
	    showC.setBounds(185, 165 , 80, 40);
	    
	    cPanel.add(idC);
	    cPanel.add(idCText);
	    cPanel.add(nameC);
	    cPanel.add(nameCText);
	    cPanel.add(insertC);
	    cPanel.add(deleteC);
	    cPanel.add(updateC);
	    cPanel.add(showC);
	    //cPanel.add(scrC);
	    cPanel.add(doneC);
	    
	    cPanel.setVisible(false);
	    
	    //Accounts Panel
	    frame.getContentPane().add(aPanel);
	   // tPanel.setLayout(new GridLayout(4,2));
	    aPanel.setLayout(null);
	    
	    
	    idT=new JLabel("Id Account:");
	    idT.setBounds(100, 30, 90, 40);
	    nameT=new JLabel("Type:");
	    nameT.setBounds(100, 70, 90, 40);
	    priceT=new JLabel("Total:");
	    priceT.setBounds(100, 110, 90, 40);
	    
	    idPersonT=new JLabel("Holder:");
	    idPersonT.setBounds(100, 150, 90, 40);
	    
	    idPersonText=new JTextField(15);
	    idPersonText.setBounds(195, 160, 60, 20);
	    tTable=new JTable();
	    
	    idAText=new JTextField(15);
	    idAText.setBounds(195, 40, 60, 20);
	    typeAText=new JTextField(15);
	    typeAText.setBounds(195, 80, 60, 20);
	    totalAText=new JTextField(15);
	    totalAText.setBounds(195, 120, 60, 20);
	    doneA=new JButton("Done");
	    insertA=new JButton("Insert");
	    deleteA=new JButton("Delete");
	    updateA=new JButton("Update");
	    showA=new JButton("View all");
	    insertA=new JButton("Insert");
	    deleteA=new JButton("Delete");
	    updateA=new JButton("Update");
	    showA=new JButton("View all");
	    
	    insertA.setBounds(100, 200, 80, 40);
	    deleteA.setBounds(185, 200 , 80, 40);
	    updateA.setBounds(100, 255, 80, 40);
	    showA.setBounds(185, 255 , 80, 40);
	    doneA.setBounds(140, 305, 80, 40);
	    
	    
	   
	    
	    
	    aPanel.add(idT);
	    aPanel.add(idAText);
	    
	    aPanel.add(nameT);
	    aPanel.add(typeAText);
	    
	    aPanel.add(idPersonT);
	    aPanel.add(idPersonText);
	    
	    aPanel.add(priceT);
	    aPanel.add(totalAText);
	    aPanel.add(doneA);
	    aPanel.add(insertA);
	    aPanel.add(deleteA);
	    aPanel.add(updateA);
	    aPanel.add(showA);
	    
	    
	    aPanel.setVisible(false);
	    
	    //Add Withdrawal Panel
	    frame.getContentPane().add(addWdraw);
		   // tPanel.setLayout(new GridLayout(4,2));
	    addWdraw.setLayout(null);
		    
		    
		    idP=new JLabel("Id Account:");
		    idP.setBounds(100, 30, 90, 40);
		    idAcc=new JLabel("Holder:");
		    idAcc.setBounds(100, 70, 90, 40);
		    sum=new JLabel("Sum:");
		    sum.setBounds(100, 110, 90, 40);
		    idPText=new JTextField(15);
		    idPText.setBounds(195, 80, 60, 20);
		    idAccText=new JTextField(15);
		    idAccText.setBounds(195, 40, 60, 20);
		    sumText=new JTextField(15);
		    sumText.setBounds(195, 120, 60, 20);
		    done=new JButton("Done");
		    deposit=new JButton("Deposit");
		    withdraw=new JButton("Withdraw");
		   
		    
		    deposit.setBounds(100, 160, 80, 40);
		    withdraw.setBounds(185, 160 , 90, 40);
		    done.setBounds(140, 215, 80, 40);
		    operation=new JTextArea();
		    operation.setBounds(290, 40, 250, 150);
		    
		    
		   
		    
		    addWdraw.add(operation);
		    addWdraw.add(idP);
		    addWdraw.add(idPText);
		    
		    addWdraw.add(idAcc);
		    addWdraw.add(idAccText);
		    
		    addWdraw.add(sum);
		    addWdraw.add(sumText);
		    addWdraw.add(done);
		    addWdraw.add(deposit);
		    addWdraw.add(withdraw);
		    
		    
		    addWdraw.setVisible(false);
	    
	    
	    clientB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cPanel.setVisible(true);
				menuPanel.setVisible(false);
				aPanel.setVisible(false);
				addWdraw.setVisible(false);
				
			}
		});
	    
	    accB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				aPanel.setVisible(true);
				menuPanel.setVisible(false);
				cPanel.setVisible(false);
				addWdraw.setVisible(false);
				
			}
		});
	    
	    addWdrawB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addWdraw.setVisible(true);
				menuPanel.setVisible(false);
				cPanel.setVisible(false);
				aPanel.setVisible(false);
				
			}
		});
 doneC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cPanel.setVisible(false);
				menuPanel.setVisible(true);
				aPanel.setVisible(false);
				addWdraw.setVisible(false);
			    idCText.setText("");
			    nameCText.setText("");
				
			}
		});
 doneA.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			cPanel.setVisible(false);
			menuPanel.setVisible(true);
			aPanel.setVisible(false);
			addWdraw.setVisible(false);
			
			    idAText.setText("");
			    typeAText.setText("");
			    totalAText.setText("");
			
		}
	});
 done.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			cPanel.setVisible(false);
			menuPanel.setVisible(true);
			aPanel.setVisible(false);
			addWdraw.setVisible(false);
			idPText.setText("");
			idAccText.setText("");
			sumText.setText("");
			operation.setText("");;
			
		}
	});
 
 showC.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Bank b=new Bank();
			b=b.deserialization();
			//for(Person p:b.getHolder().keySet())
			//	idCText.setText(p.getName());
			String [] columnNames= {"Id", "Name"};
			Object [][] rows=new Object[b.getHolder().keySet().size()][2];
			int i=0;
			
			
			for ( Person key : b.getHolder().keySet() ) {
			    rows[i][0]=key.getId();
			    rows[i][1]=key.getName();
			    i++;
			}
			
		    cTable=new JTable(rows,columnNames);
		    
		    JScrollPane scrC=new JScrollPane(cTable);
		    scrC.setBounds(280, 40, 300, 150);
		    cPanel.add(scrC);

		
		    cTable.addMouseListener(new java.awt.event.MouseAdapter()
		    {
		     public void mouseClicked(java.awt.event.MouseEvent e)
		   {
		   int row1=cTable.rowAtPoint(e.getPoint());
		   int col1= cTable.columnAtPoint(e.getPoint());
		     System.out.println(" Value in the cell clicked :"+ " " +cTable.getValueAt(row1,col1).toString());
		     System.out.println(row1+" "+col1);
		     if(col1==0)
		     {
		    	 idCText.setText(cTable.getValueAt(row1,col1).toString());
		     }
		     else if(col1 == 1) {
		    	 nameCText.setText(cTable.getValueAt(row1,col1).toString());
		    	 
		     }
		   }
		    });
		
				
		    idCText.setText("");
		    nameCText.setText("");
		}
	});

 
 showA.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Bank b=new Bank();
			b=b.deserialization();
			int total=0, i=0;
			
			String [] columnNames= {"Id", "Sum","Type","Id Person"};
			for ( Person key : b.getHolder().keySet() ) {
			    if(b.getHolder().get(key)!=null) {
			    for (Account a:b.getHolder().get(key))
					total++;
			    }
			}
		
			Object [][] rows=new Object[total][4];
			
			
			
			for ( Person key : b.getHolder().keySet() ) {
				if(b.getHolder().get(key)!=null) {
				for(Account a: b.getHolder().get(key)) {
					rows[i][0]=a.getId();
				    rows[i][1]=a.getMoney();
				    rows[i][2]=a.getTip();
				    rows[i][3]=a.getIdPerson();
				    i++;
				}
				}
			    
			}
			
			tTable=new JTable(rows,columnNames);
		
			JScrollPane scrA=new JScrollPane(tTable);
		    scrA.setBounds(280, 40, 300, 150);
		    aPanel.add(scrA);	
		    
		    
		    tTable.addMouseListener(new java.awt.event.MouseAdapter() {
			    @Override
			    public void mouseClicked(java.awt.event.MouseEvent evt) {
			        int row = tTable.rowAtPoint(evt.getPoint());
			        int col = tTable.columnAtPoint(evt.getPoint());
			        if (row >= 0 && col >= 0) {
			        	if(col == 0) {
			        		idAText.setText(tTable.getValueAt(row,col).toString());
			        	}
			        	
			        	else if(col == 3) {
			        		idPersonText.setText(tTable.getValueAt(row,col).toString());
			        	}
			        	else if(col == 2) {
			        		typeAText.setText(tTable.getValueAt(row,col).toString());
			        	}
			        	
			        	
			        	System.out.println(row+" "+col);

			        }
			    }
			});
		    idAText.setText("");
		    typeAText.setText("");
		    totalAText.setText("");
		    idPersonText.setText("");
		}
	});
 
 insertC.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String id=idCText.getText();
			String name=nameCText.getText();
			Person p=new Person(id,name);
			Bank b=new Bank();
			b=b.deserialization();
			b.initializeObservers();
			b.addPerson(p);	
			b.serialization(b);
			idCText.setText("");
		    nameCText.setText("");
		}
	});
 deleteC.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String id=idCText.getText();
			List<Person> toRemove=new ArrayList<>();
			//String name=nameCText.getText();
			Bank b=new Bank();
			b=b.deserialization();
			b.initializeObservers();
			//forrrrrr
			for(Person p:b.getHolder().keySet()) {
				if(p.getId().equals(id)) {
					toRemove.add(p);
					//b.removePerson(p);
					
				}
			}
			b.getHolder().keySet().removeAll(toRemove);
			b.serialization(b);
			idCText.setText("");
		    nameCText.setText("");
		}
	});
 updateC.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String id=idCText.getText();
			String name=nameCText.getText();
			Bank b=new Bank();
			b=b.deserialization();
			b.initializeObservers();
			for(Person p:b.getHolder().keySet()) {
				if(p.getId().equals(id)) {
					p.setName(name);
					for(Account a:b.getHolder().get(p)) {
						a.setIdPerson(name);
					}
					
				}
			}
			
			b.serialization(b);
			idCText.setText("");
		    nameCText.setText("");
		}
	});
 
 insertA.addActionListener(new ActionListener() {
		
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			int id=Integer.parseInt(idAText.getText());
			String idP=idPersonText.getText();
			String tip=typeAText.getText();
			double sum=Double.parseDouble(totalAText.getText());
			Bank b=new Bank();
			b=b.deserialization();
			b.initializeObservers();
			//System.out.println(tip);
			if(tip.equals("Saving")) {
				for(Person p:b.getHolder().keySet()) {
					if(p.getName().equals(idP)) {
						System.out.println(tip);
						SavingAccount s=new SavingAccount(id,sum,idP);
						b.addAccount(p, s);
						s.addObserver(p);
					}
				}
			}
			else if(tip.equals("Spending")) {
				for(Person p:b.getHolder().keySet()) {
					if(p.getName().equals(idP)) {
						SpendingAccount s=new SpendingAccount(id,sum,idP);
						b.addAccount(p, s);
						idAText.setText(p.getName());
						s.addObserver(p);
					}
				}
				
			}
			b.serialization(b);
			//idAText.setText("");
			typeAText.setText("");
		    idPersonText.setText("");
		    totalAText.setText("");
		}
	});
deleteA.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int id=Integer.parseInt(idAText.getText());
			String idP=idPersonText.getText();
			//String tip=typeAText.getText();
			//int sum=Integer.parseInt(totalAText.getText());
			Bank b=new Bank();
			List<Account> toRemove=new ArrayList<>();
			b=b.deserialization();
			b.initializeObservers();
			
	
			for(Person p:b.getHolder().keySet()) {
				if(p.getName().equals(idP)) {
					for(Account a: b.getHolder().get(p)) {
						if(a.getId() == id) {
							//b.removeAccount(p,a);
							toRemove.add(a);
						}
						
					}
					b.getHolder().get(p).removeAll(toRemove);
				}
				
			}
			
			
			b.serialization(b);
			idAText.setText("");
			typeAText.setText("");
		    idPersonText.setText("");
		    totalAText.setText("");
		}
	});
updateA.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int id=Integer.parseInt(idAText.getText());
			String idP=idPersonText.getText();
			String tip=typeAText.getText();
			double sum=Double.parseDouble(totalAText.getText());
			Bank b=new Bank();
			b=b.deserialization();
			b.initializeObservers();
			for(Person p:b.getHolder().keySet()) {
				if(p.getName().equals(idP)) {
					for(Account a: b.getHolder().get(p)) {
						if(a.getId() == id) {
							if(a.getTip().equals("Saving")) {
								a.setMoney(sum+sum*3/100);
							}
							else if(a.getTip().equals("Spending")) {
								a.setMoney(sum);
							}
							//this.money=this.money+this.money*3/100;
							a.setTip(tip);
							
						}
					}
				}
			}
			
			b.serialization(b);
			idAText.setText("");
			typeAText.setText("");
		    idPersonText.setText("");
		    totalAText.setText("");
		}
	});

deposit.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int id=Integer.parseInt(idAccText.getText());
		String idP=idPText.getText();
		double sum=Double.parseDouble(sumText.getText());
		Bank b=new Bank();
		b=b.deserialization();
		b.initializeObservers();
		for(Person p:b.getHolder().keySet()) {
			if(p.getName().equals(idP)) {
				for(Account a: b.getHolder().get(p)) {
					if(a.getId() == id) {
						a.deposit(sum);
						operation.append(a.toStringDeposit());
					}
				}
			}
		}
		
		b.serialization(b);
		idPText.setText("");
		idAccText.setText("");
		sumText.setText("");
	}
});

withdraw.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		int id=Integer.parseInt(idAccText.getText());
		String idP=idPText.getText();
		double sum=Double.parseDouble(sumText.getText());
		Bank b=new Bank();
		b=b.deserialization();
		b.initializeObservers();
		for(Person p:b.getHolder().keySet()) {
			if(p.getName().equals(idP)) {
				for(Account a: b.getHolder().get(p)) {
					if(a.getId() == id) {
						a.withdrawal(sum);
						operation.append(a.toStringWithdrawal());
					}
				}
			}
		}
		
		b.serialization(b);
		idPText.setText("");
		idAccText.setText("");
		sumText.setText("");
	}
});

}   
	      
		
	

	
	public static void main(String[] args) {
		initInterface();
	}

}
