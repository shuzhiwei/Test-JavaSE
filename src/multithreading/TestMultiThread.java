/*package multithreading;

public class TestMultiThread {
	public static void main(String[] args) {
		Sale s = new Sale();
		for(int i=0; i<10; i++){
			new Thread(s,"����"+i).start();
		}
	}
}

class Sale implements Runnable{
	private int num=10000;

	@Override
	public void run() {
		while(true){
			synchronized(this){
				if(num > 0){
					num--;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "����һ��Ʊ, ��ʣ" + num + "��Ʊ");
				}
			}
		}
		
	}
	
	
}


class Sale implements Runnable{
	private int num = 100;

	@Override
	public void run() {
		while(num > 0){
			sale();
		}
		
	}
	
	public synchronized void sale(){
		
		if(num > 0){
			num--;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "����һ��Ʊ, ��ʣ��" + num + "��Ʊ");
			
		}
		
	}
	
	
}
*/