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
	
	public void run() {
				
	}
}
