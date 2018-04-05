package fork;

public class Fork {
	
	//Data members
	public boolean inUse;
	public Integer position;
	
	//Fork construtor
	public Fork(Integer _position) {
		this.position = _position;
	}
	
	//Pick up fork method
	public synchronized void Hold() {
		this.inUse = true;
	}
	
	//Drop fork method
	public synchronized void Drop() {
		this.inUse = false;
	}
}
