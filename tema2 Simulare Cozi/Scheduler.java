package tema2;

import java.util.ArrayList;
import java.util.Collections;

public class Scheduler {
	private ArrayList<Queue>queues=new ArrayList<>();
	
	public Scheduler(int nrQueues) {
		for(int i=0;i < nrQueues;i++) {
			queues.add(new Queue());
		}
		for(Queue q:queues) {
			Thread t=new Thread(q);
			t.start();
		}
	}
	
	
	public void adaugare(Queue q,Client client) {
		q.addClient(client);
	}
	public ArrayList<Queue> getQueues() {
		return queues;
	}
	public void sortQ() {
		Collections.sort(queues);
	}
	
	
	
	
	

}
