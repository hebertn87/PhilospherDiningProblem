package philosopher;

import fork.Fork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Philosopher implements Runnable {

	private Fork rightFork;
	private Fork leftFork;
	private Integer position;

	private static Logger logger = LogManager.getLogger();
	
	//Constructor
	public Philosopher (Fork _leftFork, Fork _rightFork, Integer _position) {
		this.rightFork = _rightFork;
		this.leftFork = _leftFork;
		this.position = _position;
	}
	
	//Run method
	public void run(){
		//Try loop that handles the error level of this run loop
		try {
			//Thread loop, includes synchronized
			while(true) {
				synchronized(leftFork) {
					leftFork.Hold();
					logger.debug("Philosopher " + position + " picked up Fork " + leftFork.position);
					synchronized(rightFork) {
						rightFork.Hold();
						logger.debug("Philosopher " + position + " picked up Fork " + rightFork.position);
					
						//If the current thread holds both their forks, they can eat
						if(leftFork.inUse && rightFork.inUse) {
							Eat();			
						}
						rightFork.Drop();
						logger.debug("Philosopher " + position + " has dropped fork " + rightFork.position);
					}
					leftFork.Drop();
					logger.debug("Philosopher " + position + " has dropped fork " + leftFork.position);
				}
				Think(); //They think after or as they eat
			}
		}catch(Exception e) {
			logger.error(e);
		}
	}
	
	//Method to sleep
	public void Think() {
		try {
			logger.trace("Philosopher " + position + " is waiting...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.warn("Philosopher " + position + " was interrupted.");
			logger.warn(e);
		}
	}
	
	//Method to eat
	public void Eat() {
		logger.info("Philosopher " + position + " is eating.");
	}
}
