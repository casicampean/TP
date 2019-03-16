package presentation;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import businessLayer.CustomerBLL;
import businessLayer.OrderBLL;
import businessLayer.ProductBLL;
import businessLayer.TransportBLL;
import dataAccess.ReflectionExample;
import model.Customer;
import model.Order;
import model.Product;
import model.Transport;

/**
 * @author Casi
 *intrfata grafica 
 */
public class Interface {
	static JFrame frame;
	static JLabel idCOrder,idPOrder,idTOrder,cantitate,idC,nameC,idP,nameP,cantitateP,priceP,idT,nameT,priceT;
	static JButton customerOButton,productOButton,transportOButton,orderButton,orderB,doneC,doneP,doneT,doneO;
	static JButton insertC,deleteC,updateC,insertP,deleteP,updateP,insertT,deleteT,updateT;
	static JButton showP, showC, showT;
	static JTextField idCOText,idPOText,idTOText,cantitateOText,idCText,nameCText,idPText,namePText;
	static JTextField cantitatePText,pricePText,idTText,nameTText,priceTText;
	static JPanel cPanel,pPanel,tPanel,oPanel,menuPanel;
	static JTextArea factura;
	static JTable cTable,pTable,tTable;
	
	/**
	 * metoda care initializeaza interfata
	 */
	public static void initInterface() {
		frame=new JFrame("Tema 3");
	    cPanel=new JPanel();
	    pPanel=new JPanel();
	    tPanel=new JPanel();
	    oPanel=new JPanel();
	    menuPanel=new JPanel();
	    //frame.add(cPanel);
	    //frame.add(pPanel);
	    //frame.add(cPanel);
	    //frame.add(tPanel);
	    //frame.add(menuPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(600,400);
	    frame.setVisible(true);
	    frame.getContentPane().setLayout(new CardLayout(0,0));
	    
	    
	    //Menu Panel
	    frame.getContentPane().add(menuPanel);
	    //menuPanel.setLayout(new GridLayout(4,1));
	    menuPanel.setLayout(null);
	    
	    customerOButton=new JButton("Customer Operations");
	    productOButton=new JButton("Product Operations");
	    transportOButton=new JButton("Transport Operations");
	    orderButton=new JButton("Make Order");
	    
	    customerOButton.setBounds(170, 40, 170, 50);
	    productOButton.setBounds(170, 120, 170, 50);
	    transportOButton.setBounds(170, 200, 170, 50);
	    orderButton.setBounds(170, 280, 170, 50);
	    
	    //customerOButton.setPreferredSize(new Dimension(10, 20));
	    
	    menuPanel.add(customerOButton);
	    menuPanel.add(productOButton);
	    menuPanel.add(transportOButton);
	    menuPanel.add(orderButton);
	    
	    menuPanel.setVisible(true);
	    
	    
	    //Customer Panel
	    frame.getContentPane().add(cPanel);
	    cPanel.setLayout(new GridLayout(3,2));
	    cPanel.setLayout(null);
	    
	    idC=new JLabel("Id Customer:");
	    idC.setBounds(100, 30, 90, 40);
	    nameC=new JLabel("Name:");
	    nameC.setBounds(100, 70, 90, 40);
	    cTable=new JTable();
	    idCText=new JTextField(15);
	    idCText.setBounds(195, 40, 60, 20);
	    nameCText=new JTextField(15);
	    nameCText.setBounds(195, 80, 60, 20);
	    doneC=new JButton("Done");
	    JScrollPane scrC=new JScrollPane(cTable);
	    scrC.setBounds(280, 40, 300, 150);
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
	    cPanel.add(scrC);
	    cPanel.add(doneC);
	    
	    cPanel.setVisible(false);
	    
	    //Product Panel
	    frame.getContentPane().add(pPanel);
	    //pPanel.setLayout(new GridLayout(5,2));
	    pPanel.setLayout(null);
	    idP=new JLabel("Id Product:");
	    idP.setBounds(100, 30, 90, 40);
	    nameP=new JLabel("Name:");
	    nameP.setBounds(100, 70, 90, 40);
	    cantitateP=new JLabel("Quantity:");
	    cantitateP.setBounds(100, 110, 90, 40);
	    priceP=new JLabel("Price:");
	    priceP.setBounds(100, 150, 90, 40);
	    pTable=new JTable();
	    idPText=new JTextField(15);
	    idPText.setBounds(195, 40, 60, 20);
	    namePText=new JTextField(15);
	    namePText.setBounds(195, 80, 60, 20);
	    cantitatePText=new JTextField(15);
	    cantitatePText.setBounds(195, 120, 60, 20);
	    pricePText=new JTextField(15);
	    pricePText.setBounds(195, 160, 60, 20);
	    doneP=new JButton("Done");
	    insertP=new JButton("Insert");
	    deleteP=new JButton("Delete");
	    updateP=new JButton("Update");
	    showP=new JButton("View all");
	    insertP.setBounds(100, 200, 80, 40);
	    deleteP.setBounds(185, 200 , 80, 40);
	    updateP.setBounds(100, 255, 80, 40);
	    showP.setBounds(185, 255 , 80, 40);
	    doneP.setBounds(140, 305, 80, 40);
	    
	    
	    pPanel.add(idP);
	    pPanel.add(idPText);
	    pPanel.add(nameP);
	    pPanel.add(namePText);
	    pPanel.add(cantitateP);
	    pPanel.add(cantitatePText);
	    pPanel.add(priceP);
	    pPanel.add(pricePText);
	    pPanel.add(insertP);
	    pPanel.add(deleteP);
	    pPanel.add(updateP);
	    pPanel.add(showP);
	    pPanel.add(doneP);
	    
	    pPanel.setVisible(false);
	    
	    //Transport Panel
	    frame.getContentPane().add(tPanel);
	   // tPanel.setLayout(new GridLayout(4,2));
	    tPanel.setLayout(null);
	    
	    
	    idT=new JLabel("Id Transport:");
	    idT.setBounds(100, 30, 90, 40);
	    nameT=new JLabel("Name:");
	    nameT.setBounds(100, 70, 90, 40);
	    priceT=new JLabel("Price:");
	    priceT.setBounds(100, 110, 90, 40);
	    tTable=new JTable();
	    idTText=new JTextField(15);
	    idTText.setBounds(195, 40, 60, 20);
	    nameTText=new JTextField(15);
	    nameTText.setBounds(195, 80, 60, 20);
	    priceTText=new JTextField(15);
	    priceTText.setBounds(195, 120, 60, 20);
	    doneT=new JButton("Done");
	    insertT=new JButton("Insert");
	    deleteT=new JButton("Delete");
	    updateT=new JButton("Update");
	    showT=new JButton("View all");
	    insertT=new JButton("Insert");
	    deleteT=new JButton("Delete");
	    updateT=new JButton("Update");
	    showT=new JButton("View all");
	    
	    insertT.setBounds(100, 160, 80, 40);
	    deleteT.setBounds(185, 160 , 80, 40);
	    updateT.setBounds(100, 215, 80, 40);
	    showT.setBounds(185, 215 , 80, 40);
	    doneT.setBounds(140, 265, 80, 40);
	    
	    
	   
	    
	    
	    tPanel.add(idT);
	    tPanel.add(idTText);
	    
	    tPanel.add(nameT);
	    tPanel.add(nameTText);
	    
	    tPanel.add(priceT);
	    tPanel.add(priceTText);
	    tPanel.add(doneT);
	    tPanel.add(insertT);
	    tPanel.add(deleteT);
	    tPanel.add(updateT);
	    tPanel.add(showT);
	    
	    
	    tPanel.setVisible(false);
	    
	    //Order Panel
	    frame.getContentPane().add(oPanel);
	    oPanel.setLayout(null);
	    
	    
	    
	    idCOrder=new JLabel("id Customer:");
	    idCOrder.setBounds(100, 30, 90, 40);
	    idPOrder=new JLabel("id Product:");
	    idPOrder.setBounds(100, 70, 90, 40);
	    idTOrder=new JLabel("id Transport:");
	    idTOrder.setBounds(100, 110, 90, 40);
	    cantitate=new JLabel("Quantity:");
	    cantitate.setBounds(100, 150, 90, 40);
	    idCOText=new JTextField(15);
	    idCOText.setBounds(195, 40, 60, 20);
	    idPOText=new JTextField(15);
	    idPOText.setBounds(195, 80, 60, 20);
	    idTOText=new JTextField(15);
	    idTOText.setBounds(195, 120, 60, 20);
	    cantitateOText=new JTextField(15);
	    cantitateOText.setBounds(195, 160, 60, 20);
	    doneO=new JButton("Done");
	    orderB=new JButton("Order");
	    orderB.setBounds(100, 200, 80, 40);
	    doneO.setBounds(185, 200, 80, 40);
	    factura=new JTextArea();
	    factura.setBounds(280, 40, 200, 150);
	    
	    oPanel.add(idCOrder);
	    oPanel.add(idCOText);
	    
	    oPanel.add(idPOrder);
	    oPanel.add(idPOText);
	    
	    oPanel.add(idTOrder);
	    oPanel.add(idTOText);
	    
	    oPanel.add(cantitate);
	    oPanel.add(cantitateOText);
	    oPanel.add(orderB);
	    oPanel.add(doneO);
	    oPanel.add(factura);
	
	    oPanel.setVisible(false);
	    
	    customerOButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cPanel.setVisible(true);
				menuPanel.setVisible(false);
				pPanel.setVisible(false);
				oPanel.setVisible(false);
				tPanel.setVisible(false);
				
			}
		});
	    
       productOButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pPanel.setVisible(true);
				menuPanel.setVisible(false);
				cPanel.setVisible(false);
				oPanel.setVisible(false);
				tPanel.setVisible(false);
				
			}
		});
       transportOButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tPanel.setVisible(true);
				menuPanel.setVisible(false);
				oPanel.setVisible(false);
				cPanel.setVisible(false);
				pPanel.setVisible(false);
				
			}
		});
       orderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				oPanel.setVisible(true);
				menuPanel.setVisible(false);
				pPanel.setVisible(false);
				cPanel.setVisible(false);
				tPanel.setVisible(false);
				
			}
		});
       doneP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pPanel.setVisible(false);
				menuPanel.setVisible(true);
				cPanel.setVisible(false);
				oPanel.setVisible(false);
				tPanel.setVisible(false);
				
			}
		});
       doneC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pPanel.setVisible(false);
				menuPanel.setVisible(true);
				cPanel.setVisible(false);
				oPanel.setVisible(false);
				tPanel.setVisible(false);
				
			}
		});
       doneT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pPanel.setVisible(false);
				menuPanel.setVisible(true);
				cPanel.setVisible(false);
				oPanel.setVisible(false);
				tPanel.setVisible(false);
				
			}
		});
       doneO.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pPanel.setVisible(false);
				menuPanel.setVisible(true);
				cPanel.setVisible(false);
				oPanel.setVisible(false);
				tPanel.setVisible(false);
				factura.setText("");
				
			}
		});
       orderB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i=3;
				//fac facutra
				//afisez in frame factura sau produse insuficiente
				int idC=Integer.parseInt(idCOText.getText());
				int idP=Integer.parseInt(idPOText.getText());
				int idT=Integer.parseInt(idTOText.getText());
				int cant=Integer.parseInt(cantitateOText.getText());
				CustomerBLL c=new CustomerBLL();
				ProductBLL p=new ProductBLL();
				TransportBLL t=new TransportBLL();
				Customer customer=c.findCustomerById(idC);
				Product product=p.findProductById(idP);
				Transport transport=t.findTransportById(idT);
				if(product.getQuantity() - cant >= 0) {
					factura.append("ORDER BILL\n");
					factura.append("Customer: "+customer.getName()+"\n");
					factura.append("Product: "+product.getName()+"\n");
					factura.append("Quantity: "+cant+"\n");
					int pret=cant * product.getPrice();
					factura.append("Price: "+pret+"\n");
					factura.append("Trasport: "+transport.getName()+"\n");
					factura.append("Pret transport: "+transport.getPrice()+"\n");
					int total=transport.getPrice()+pret;
					factura.append("Total price: "+total+"\n");
					product.setQuantity(product.getQuantity()-cant);
					Order o=new Order(i,customer.getId(),product.getId(),transport.getId());
					i++;
					OrderBLL or=new OrderBLL();
					or.insertOrder(o);
					
				}
				else {
				     factura.append("Product currently unavailable");
				}
				idCOText.setText("");
			    idPOText.setText("");
			    idTOText.setText("");
			    cantitateOText.setText("");
			}
			
		});
       insertC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idCText.getText());
				String name=nameCText.getText();
				Customer c=new Customer(id,name);
				CustomerBLL cus=new CustomerBLL();
				cus.insertCustomer(c);	
				idCText.setText("");
			    nameCText.setText("");
			}
		});
       deleteC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idCText.getText());
				CustomerBLL cus=new CustomerBLL();
				cus.deleteCustomer(id);		
				idCText.setText("");
			    nameCText.setText("");
			}
		});
       updateC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idCText.getText());
				String name=nameCText.getText();
				Customer c=new Customer(id,name);
				CustomerBLL cus=new CustomerBLL();
				cus.updateCustomer(c);	
				idCText.setText("");
			    nameCText.setText("");
			}
		});
       insertP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idPText.getText());
				String name=namePText.getText();
				int quantity=Integer.parseInt(cantitatePText.getText());
				int price=Integer.parseInt(pricePText.getText());
				Product p=new Product(id,name,quantity,price);
				ProductBLL pr=new ProductBLL();
				pr.insertProduct(p);
				idPText.setText("");
			    namePText.setText("");
				cantitatePText.setText("");
				pricePText.setText("");
			}
		});
       deleteP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idPText.getText());
				ProductBLL pr=new ProductBLL();
				pr.deleteProduct(id);	
				idPText.setText("");
			    namePText.setText("");
				cantitatePText.setText("");
				pricePText.setText("");
			}
		});
       updateP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idPText.getText());
				String name=namePText.getText();
				int quantity=Integer.parseInt(cantitatePText.getText());
				int price=Integer.parseInt(pricePText.getText());
				Product p=new Product(id,name,quantity,price);
				ProductBLL pr=new ProductBLL();
				pr.updateProduct(p);	
				idPText.setText("");
			    namePText.setText("");
				cantitatePText.setText("");
				pricePText.setText("");
			}
		});
       insertT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idTText.getText());
				String name=nameTText.getText();
				int price=Integer.parseInt(priceTText.getText());
				Transport t=new Transport(id,name,price);
				TransportBLL tr=new TransportBLL();
				tr.insertTransport(t);
				idTText.setText("");
			    nameTText.setText("");
			    priceTText.setText("");	
				
			}
		});
       deleteT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idTText.getText());
				TransportBLL tr=new TransportBLL();
				tr.deleteTransport(id);		
				idTText.setText("");
			    nameTText.setText("");
			    priceTText.setText("");	
			}
		});
       updateT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(idTText.getText());
				String name=nameTText.getText();
				int price=Integer.parseInt(priceTText.getText());
				Transport t=new Transport(id,name,price);
				TransportBLL tr=new TransportBLL();
				tr.updateTransport(t);
				idTText.setText("");
			    nameTText.setText("");
			    priceTText.setText("");	
			}
		});
       showP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProductBLL tr=new ProductBLL();
				ArrayList<Product>tt=tr.selectProduct();
				pTable=ReflectionExample.retrieveProperties(tt,4);
				JScrollPane scrP=new JScrollPane(pTable);
			    scrP.setBounds(280, 40, 300, 150);
			    pPanel.add(scrP);	
			    idPText.setText("");
			    namePText.setText("");
				cantitatePText.setText("");
				pricePText.setText("");
			}
		});
       showC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerBLL tr=new CustomerBLL();
				ArrayList<Customer>tt=tr.selectCustomer();
				cTable=ReflectionExample.retrieveProperties(tt,2);
				JScrollPane scrC=new JScrollPane(cTable);
			    scrC.setBounds(280, 40, 300, 150);
			    cPanel.add(scrC);	
			    idCText.setText("");
			    nameCText.setText("");
			}
		});
       showT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TransportBLL tr=new TransportBLL();
				ArrayList<Transport>tt=tr.selectTransport();
				tTable=ReflectionExample.retrieveProperties(tt,3);
				JScrollPane scrT=new JScrollPane(tTable);
			    scrT.setBounds(280, 40, 300, 150);
			    tPanel.add(scrT);
			    idTText.setText("");
			    nameTText.setText("");
			    priceTText.setText("");	
			    
			    
			}
		});
       
       
       
       
	    
	    
	    
	    
	    
		
	}
	public static void main(String[] args) {
		initInterface();
	}

}
