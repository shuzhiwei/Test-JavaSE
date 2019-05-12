package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestExer03 {
	public static void main(String[] args) {
		AAA a = new AAA();
		new Thread(new Runnable(){
			public void run(){
				for(int i=0; i<10; i++){
					a.loopA();
				}
			}
		},"A").start();
		new Thread(new Runnable(){
			public void run(){
				for(int i=0; i<10; i++){
					a.loopB();
				}
			}
		},"B").start();
		new Thread(new Runnable(){
			public void run(){
				for(int i=0; i<10; i++){
					a.loopC();
				}
			}
		},"C").start();
	}

}
class AAA{
	private int num=1;
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	
	public void loopA(){
		lock.lock();
		try{
			if(num != 1){
				try {
					c1.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName());
			num = 2;
			c2.signal();
		}finally{
			lock.unlock();
		}
	}
	public void loopB(){
		lock.lock();
		try{
			if(num != 2){
				try {
					c2.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName());
			num = 3;
			c3.signal();
		}finally{
			lock.unlock();
		}
	}
	public void loopC(){
		lock.lock();
		try{
			if(num != 3){
				try {
					c3.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.print(Thread.currentThread().getName());
			num = 1;
			c1.signal();
		}finally{
			lock.unlock();
		}
	}
}