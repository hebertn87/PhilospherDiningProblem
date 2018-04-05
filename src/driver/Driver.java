package driver;

import fork.Fork;
import philosopher.Philosopher;

public class Driver {
	public static void main(String[] args) {
		
		//Create an array of forks and an array of phils
		Fork[] forks = new Fork[5];
		Philosopher[] thinker = new Philosopher[5];
		
		//Initialize Fork		
		for(int i = 0; i < forks.length; i++) {
			forks[i] = new Fork(i);
		}
		
		
		//This is currently how my philosopher are instantiated in the loop
		//thinker 0 = forks[0], forks[1]);
		//thinker 1 = forks[1], forks[2]);
		//thinker 2 = forks[2], forks[3]);
		//thinker 3 = forks[3], forks[4]);
		//thinker 4 = forks[4], forks[0]);
		for(int i = 0; i < thinker.length; i++) {
			Fork leftFork = forks[i];
			Fork rightFork = forks[(i + 1) % forks.length];
			
			thinker[i] = new Philosopher(leftFork, rightFork, i);
			Thread myThread = new Thread(thinker[i]);
			myThread.start();
		}
	}
}
