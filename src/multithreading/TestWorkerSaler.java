package multithreading;

public class TestWorkerSaler {
	public static void main(String[] args) {
		//1、建立仓库
		Houseware house = new Houseware();
		
		//2、启动工人线程
		new Worker(house).start();
		//3、启动销售线程
		new Saler(house).start();
	}
}
class Houseware{
	private int total;//表示当前仓库中的电视机数量
	private static final int MAX_VALUE = 10;
	
	/*
	 * 生产者调用这个方法，往仓库放电视
	 * 锁对象：this
	 */
	public synchronized void add(){
		if(total >= MAX_VALUE){//当仓库满时，生产者停下来，生产线程进入阻塞状态
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		total++;
		try {
			//为了放大问题
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("生产者生产了一台电视机，当前库存是："+total);
		//唤醒正在等待的线程
		this.notify();
		System.out.println("生产者......");
	}
	
	/*
	 * 销售人员调用这个方法，从仓库拿电视
	 * 锁对象：this
	 */
	public synchronized void take(){
		if(total<=0){//当仓库空时，销售员休息，销售线程，进入阻塞状态
			try {
				//休息
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		total--;
		try {
			//为了放大问题
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("销售者卖了一台电视机，当前库存是："+total);
		//唤醒正在等待的线程
		this.notify();
		System.out.println("销售者......");
	}
}

class Worker extends Thread{
	private Houseware h;
	
	public Worker(Houseware h){
		this.h = h;
	}
	
	public void run(){
		while(true){
			h.add();
		}
	}
}
class Saler extends Thread{
	private Houseware h;
	
	public Saler(Houseware h){
		this.h = h;
	}
	
	public void run(){
		while(true){
			h.take();
		}
	}
}
