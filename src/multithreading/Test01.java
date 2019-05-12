/*package multithreading;

public class Test01 {
	public static void main(String[] args) {
		Saler s = new Saler();
		
		new Thread(s,"窗口一").start();
		new Thread(s,"窗口二").start();
		new Thread(s,"窗口三").start();
	}
}
class Saler implements Runnable{
	private int total = 10;

	@Override
	public void run() {
		while(total>0){
			//synchronized (this) {
				//卖票
				sale();
			//}
		}
	}
	
	public synchronized void sale(){
		if(total>0){
			total--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"卖了一张票，剩余：" + total);
		}
	}
	
}*/