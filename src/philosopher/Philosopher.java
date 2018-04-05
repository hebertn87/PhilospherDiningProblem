package philosopher;

import fork.Fork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Philosopher implements Runnable {

	private Fork rightFork;
	private Fork leftFork;
	private Integer position;

	private static Logger logger = LogManager.getLogger();
	
	public Philosopher (Fork _leftFork, Fork _rightFork, Integer _position) {
		this.rightFork = _rightFork;
		this.leftFork = _leftFork;
		this.position = _position;
	}
	
	public void run(){
				//Thread loop, includes synchronized
				while(true) {
					synchronized(leftFork) {
						leftFork.Hold();
						logger.info("Philosopher " + position + " picked up Fork " + leftFork.position);
						synchronized(rightFork) {
							rightFork.Hold();
							logger.info("Philosopher " + position + " picked up Fork " + rightFork.position);
						
							//If the current thread holds both their forks, they can eat
							if(leftFork.inUse && rightFork.inUse) {
								Eat();			
							}
						}
					}
					Think(); //They think after or as they eat
				}
	}
	
	public void Think() {
		try {
			logger.info("Philosopher " + position + " is thinking...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.warn("Philosopher " + position + " was interrupted.");
		}
	}
	
	public void Eat() {
		logger.info("Philosopher " + position + " is eating.");
	}
}
