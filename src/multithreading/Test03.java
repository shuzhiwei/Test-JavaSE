package multithreading;

public class Test03 {
	public static void main(String[] args) {
		
	}

}
class Q{
	private int total;
	private final int MAX_NUM = 10;
	public synchronized void add(){
		if(total >= MAX_NUM){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		total++;
		this.notify();
	}
	
	public synchronized void sale(){
		if(total <= 0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		total--;
		this.notify();
	}
}

class W extends Thread{
	private Q q;
	public W(){
		
	}

	public W(Q q) {
		super();
		this.q = q;
	}
	
	
	
}

class E extends Thread{
	private Q q;

	public E(){
		
	}
	
	public E(Q q) {
		super();
		this.q = q;
	}
	
}





