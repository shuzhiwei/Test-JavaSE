/*package multithreading;

public class Test01 {
	public static void main(String[] args) {
		Saler s = new Saler();
		
		new Thread(s,"����һ").start();
		new Thread(s,"���ڶ�").start();
		new Thread(s,"������").start();
	}
}
class Saler implements Runnable{
	private int total = 10;

	@Override
	public void run() {
		while(total>0){
			//synchronized (this) {
				//��Ʊ
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
			System.out.println(Thread.currentThread().getName()+"����һ��Ʊ��ʣ�ࣺ" + total);
		}
	}
	
}*/