package driver;

import fork.Fork;
import philosopher.Philosopher;
import org.apache.logging.*;

public class Driver {
	public static void main(String[] args) {
		
		//Create an array of forks and an array of philosophers
		Fork[] forks = new Fork[5];
		Philosopher[] thinker = new Philosopher[5];
		
		//Initialize Fork		
		for(int i = 0; i < forks.length; i++) {
			forks[i] = new Fork(i);
		}
		
		//This is currently how my philosopher are instantiated in the loop
		//thinker 0 takes forks 0 and 1 
		//thinker 1 takes forks 1 and 2 
		//thinker 2 takes forks 2 and 3 
		//thinker 3 takes forks 3 and 4 
		//thinker 4 takes forks 4 and 0
		for(int i = 0; i < thinker.length; i++) {
			//The if statement ensures there is no deadlock. We tell the last guy to swap his forks, so he's backwards
			//Ensuring no deadlocks
			if(i == thinker.length -1 ) {
				thinker[i] = new Philosopher(forks[(i + 1) % forks.length], forks[i], i); //We modulo to ensure the last guy get's fork 0 and not fork 5
			}else {
				thinker[i] = new Philosopher(forks[i], forks[(i + 1) % forks.length], i); 
			}
			
			//Creates new threads and starts them
			Thread myThread = new Thread(thinker[i]);
			myThread.start();
		}
	}
}
