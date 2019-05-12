package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序, 开启三个线程, 这三个线程的ID分别为A,B,C, 每个线程将自己的ID在屏幕上打印10遍
 * @author 000
 *
 */
public class TestExer {
	public static void main(String[] args) {
		final ExerDemo demo = new ExerDemo();
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=1; i<=10; i++){
					demo.loopA(i);
				}
			}
			
		},"A").start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=1; i<=10; i++){
					demo.loopB(i);
				}
			}
			
		},"B").start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i=1; i<=10; i++){
					demo.loopC(i);
				}
			}
			
		},"C").start();
	}
}

class ExerDemo{
	private int num = 1;
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();
	
	public void loopA(int totalLoop){
		lock.lock();
		try {
			if(num != 1){
				try {
					condition1.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i = 1; i<=1; i++){
					System.out.print(Thread.currentThread().getName());
				}
			}
			num = 2;
			condition2.signal();
		}finally{
			lock.unlock();
		}
	}
	public void loopB(int totalLoop){
		lock.lock();
		try {
			if(num != 2){
				try {
					condition2.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i = 1; i<=1; i++){
					System.out.print(Thread.currentThread().getName());
				}
			}
			num = 3;
			condition3.signal();
		}finally{
			lock.unlock();
		}
	}
	public void loopC(int totalLoop){
		lock.lock();
		try {
			if(num != 3){
				try {
					condition3.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i = 1; i<=1; i++){
					System.out.print(Thread.currentThread().getName());
				}
			}
			num = 1;
			condition1.signal();
		}finally{
			lock.unlock();
		}
	}
	
}
