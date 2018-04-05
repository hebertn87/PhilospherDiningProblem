package philosopher;

import fork.Fork;
import log4j2.Log4J2PropertiesConf;

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
				while(true) {
					
					//The think as they eat and before/after they eat
					Think();
					
					synchronized(leftFork) {
						leftFork.Hold();
						
						logger.info("Philosopher " + position + " picked up leftFork " + leftFork.position);
						System.out.println();
						synchronized(rightFork) {
							rightFork.Hold();
							logger.info("Philosopher " + position + " picked up rightFork " + rightFork.position);
						
						
							if(leftFork.inUse && rightFork.inUse) {
								Eat();
							}
						}
					}
					
				
				}
	}
	
	public void Think() {
		try {
			logger.info("Philosopher " + position + " is thinking...");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			logger.warn("Philosopher " + position + " was interrupted.");
		}
	}
	
	public void Eat() {
		logger.info("Philosopher " + position + " is eating.");
	}
}
