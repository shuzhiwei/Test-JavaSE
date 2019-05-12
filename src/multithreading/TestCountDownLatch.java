package multithreading;

import java.util.concurrent.CountDownLatch;

/**
 * 做饭问题
 * @author 000
 *
 */
public class TestCountDownLatch {
	public static void main(String[] args) throws Exception {
		CountDownLatch cdl = new CountDownLatch(3);
		new Thread(new T1(cdl)).start();
		new Thread(new T2(cdl)).start();
		new Thread(new T3(cdl)).start();
		cdl.await();
		System.out.println("开始做饭");
	}
	

}
class T1 implements Runnable{
	private CountDownLatch cdl;
	public T1(CountDownLatch cdl){
		this.cdl = cdl;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println("锅买回来了");
			cdl.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class T2 implements Runnable{
	private CountDownLatch cdl;
	public T2(CountDownLatch cdl){
		this.cdl = cdl;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			System.out.println("米买回来了");
			cdl.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
class T3 implements Runnable{
	private CountDownLatch cdl;
	public T3(CountDownLatch cdl){
		this.cdl = cdl;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("菜买回来了");
			cdl.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

