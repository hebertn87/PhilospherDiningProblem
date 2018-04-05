package fork;

public class Fork {
	
	public boolean inUse;
	public Integer position;
	
	public Fork(Integer _position) {
		this.position = _position;
	}
	public synchronized void Hold() {
		this.inUse = true;
	}
	
	public synchronized void Drop() {
		this.inUse = false;
	}
}
