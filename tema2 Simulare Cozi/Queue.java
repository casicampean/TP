package tema2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue implements Runnable, Comparable<Object> {
	private int QId;
	private static int id=0;
	boolean running=true;
	private BlockingQueue<Client>clienti;
	private AtomicInteger timpAsteptare;
	public Queue() {
		timpAsteptare=new AtomicInteger();
		clienti=new ArrayBlockingQueue<Client>(100);
		id++;
		this.setQId(id);
	}
	
		public void addClient(Client client) {
	try {
		clienti.put(client);
		timpAsteptare.addAndGet(client.getTimpServire());
	}catch (InterruptedException e) {
        e.printStackTrace();
    }
	}
			
		
		public BlockingQueue<Client> getClienti() {
			return clienti;
		}

		@Override
		public void run() {
			while(running) {
				if(clienti.peek()!=null) {
				try {
					Thread.sleep((clienti.peek().getTimpServire())*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					
				}
				try {
					clienti.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
					
				}
				}
			}
			
		}
		public AtomicInteger getTimpAsteptare() {
			return timpAsteptare;
		}
		public void removeClient(Client c) {
			timpAsteptare.addAndGet((-1) * c.getTimpServire());
			clienti.remove(c);
			
		}
		public int timpTotal() {
			int timp=0;
			for(Client c: this.getClienti()) {
				timp+=c.getTimpServire();
			}
			return timp;
		}
		@Override
		public int compareTo(Object o) {
			return Integer.compare(this.getTimpAsteptare().get(), ((Queue)o).getTimpAsteptare().get());
		}
	
		public void stopRunning() {
			this.running=false;
		}

		public int getQId() {
			return QId;
		}

		public void setQId(int qId) {
			QId = qId;
		}
		
		
	

}
