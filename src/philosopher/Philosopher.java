package philosopher;

import fork.Fork;

public class Philosopher implements Runnable {

	private Fork rightFork;
	private Fork leftFork;
	private Integer position;
	
	public Philosopher (Fork _leftFork, Fork _rightFork, Integer _position) {
		this.rightFork = _rightFork;
		this.leftFork = _leftFork;
		this.position = _position;
	}
	
	public void run(){
				while(true) {
					synchronized(leftFork) {
						leftFork.Hold();
						System.out.println("Phil " + position + " picked up leftFork " + leftFork.position);
						synchronized(rightFork) {
							rightFork.Hold();
							System.out.println("Phil " + position + " picked up rightFork " + rightFork.position);
						}
					}
					//The think as they eat and before/after they eat
					Think();
				}
	}
	
	public void Think() {
		try {
			System.out.println("Thinker is thinking...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
