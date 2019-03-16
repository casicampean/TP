package tema2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Simulation implements Runnable {
	//data read from ui
	//max processing time read from ui
	private int timeLimit;
	private Random random=new Random();
	private int minArrivalTime;
	private int maxArrivalTime;
	private int minServingTime;
	private int maxServingTime;
	private int nrOfClients;
	private int nrQ;
	private Scheduler scheduler;
	private SimulationFrame frame;
	private ArrayList<Client>generatedClients=new ArrayList<>();
	
	public Simulation(int timeLimit,int minArrivalTime,int maxArrivalTime,int minServingTime,int maxServingTime,int nrOfClients,int nrQ) {
		this.timeLimit=timeLimit;
		this.minArrivalTime=minArrivalTime;
		this.maxArrivalTime=maxArrivalTime;
		this.minServingTime=minServingTime;
		this.maxServingTime=maxServingTime;
		this.nrOfClients=nrOfClients;
		this.nrQ=nrQ;
		
		//scheduler=new Scheduler(nrQ);
		scheduler=new Scheduler(nrQ);
		frame=new SimulationFrame();
		generateRandomClient(this.minArrivalTime, this.maxArrivalTime, this.minServingTime, this.maxServingTime, this.nrOfClients);
	}
	public ArrayList<Client> getGeneratedClients() {
		return generatedClients;
	}
	public void addClient(Client c) {
		generatedClients.add(c);
	}
	public void sortC() {
		Collections.sort(generatedClients);
	}
	public int getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	public void setMinArrivalTime(int minArrivalTime) {
		this.minArrivalTime = minArrivalTime;
	}
	public void setMaxArrivalTime(int maxArrivalTime) {
		this.maxArrivalTime = maxArrivalTime;
	}
	public int getMinArrivalTime() {
		return minArrivalTime;
	}
    public int getMaxArrivalTime() {
	    return maxArrivalTime;
    }
    public int getMaxServingTime() {
		return maxServingTime;
	}
    public int getMinServingTime() {
		return minServingTime;
	}
    public void setMaxServingTime(int maxServingTime) {
		this.maxServingTime = maxServingTime;
	}
    public void setMinServingTime(int minServingTime) {
		this.minServingTime = minServingTime;
	}
    public void setNrQ(int nrQ) {
		this.nrQ = nrQ;
	}
    public int getNrQ() {
		return nrQ;
	}
	public void generateRandomClient(int minArrivalTime,int maxArrivalTime,int minServingTime,int maxServingTime,int nrOfClients) {
		for(int i = 0; i < nrOfClients; i++) {
		int timpSosire=random.nextInt(maxArrivalTime-minArrivalTime)+minArrivalTime;
		int timpServire=random.nextInt(maxServingTime-minServingTime)+minServingTime;
	    addClient(new Client(timpSosire,timpServire));
		}
		sortC();
	    
	}

	@Override
	public void run() {
		int timpAMediu=0, iMediu=0,tMediuServire=0,jMediu=0,tAsteptareClient;
		int maxClinents=0;
		int currentTime=this.getMinArrivalTime();
		
		while(currentTime < this.timeLimit) {
			frame.toStringCoada();
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			for(Client c:generatedClients) {
				
				if(c.getTimpSosire() == currentTime) {
					Queue q=new Queue();
					scheduler.sortQ();
					q=scheduler.getQueues().get(0);
					System.out.println(q.getTimpAsteptare().get());
					tAsteptareClient=q.getTimpAsteptare().get();
					timpAMediu+=q.getTimpAsteptare().get();
				    iMediu++;
				    tMediuServire+=c.getTimpServire();
				    jMediu++;
					
					scheduler.adaugare(q, c);
					//pun in logger
					
					frame.toStringLogger("Clientul "+c.getIdClient()+" a ajuns la "+c.getTimpSosire()+" in coada "+q.getQId()+" si a asteptat "+tAsteptareClient+" secunde \n");
					for(Queue q1:scheduler.getQueues()) {
						if(q1.getClienti().size() > maxClinents) {
							maxClinents=currentTime;
						}
					}
				}
			}
				
					currentTime++;
					for(Queue q:scheduler.getQueues()) {
						if(q.getTimpAsteptare().get() > 0) {
							q.getTimpAsteptare().addAndGet(-1);
						}
					}
					//o pun in queue evolution
					for(int k=1;k<=scheduler.getQueues().size();k++) {
					for(Queue q:scheduler.getQueues()) {
						if(q.getQId() == k) {
							frame.toStringQEvolution("In coada "+q.getQId()+": ");
							for(Client c:q.getClienti()) {
								frame.toStringQEvolution(" "+c.getIdClient()+" ");
							}
							frame.toStringQEvolution("\n");
						}
					}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
		
		}
		
		for(Queue q:scheduler.getQueues()) {
			q.stopRunning();
		}
		//scriu timp final 
		
		frame.toStringLogger("Timp Mediu Asteptare: "+(double)timpAMediu/(double)iMediu);
		frame.toStringLogger("\nTimp Mediu Servire: "+(double)tMediuServire/(double)jMediu);
		frame.toStringLogger("\nTimpul cel mai aglomerat: "+maxClinents);
		
		
		
	}
	public void stopQ() {
		for(Queue q:scheduler.getQueues()) {
			q.stopRunning();
		}
	}
	public static void main(String[] args) {
		//Simulation s=new Simulation(50,10,50,1,5,50,3);
		//Thread t=new Thread(s);
		//t.start();
		

		
	}

	

}
