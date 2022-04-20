import java.util.ArrayList;
import java.util.Random;

public class CarQueue {
	ArrayList<Integer> directions;
	
	public CarQueue() {
		directions = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 5; i++)
			directions.add(rand.nextInt(1000) % 4);
	}
	
	public void addToQueue() {
		class QueueRunnable implements Runnable{
			public void run() {
				Random rand = new Random();
				for (int i = 0; i < 50; i++)
					directions.add(rand.nextInt(1000) % 4);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		QueueRunnable obj = new QueueRunnable();
		Thread t = new Thread(obj);
		t.start();
	}
	
	public int deleteQueue() {
		return directions.remove(0);
	}
}
