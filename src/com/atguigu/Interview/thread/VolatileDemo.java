package com.atguigu.Interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
	//可见性
	volatile int number = 0;
	public void add() {
		this.number = 60;
	}
	
	public void addPlusPlus(){
		number++;
	}
	
	AtomicInteger atomicInteger = new AtomicInteger();
	public void addMyAtomic(){
		atomicInteger.getAndIncrement();
	}
	
}

/**
 * 1 验证 volatile的可见性
 *   1.1 假如int number=0; number变量之前根本没有添加Volatile关键字修饰
 *   1.2 添加了volatile可以解决可见性问题
 * 2 验证volatile不保证原子性
 *   2.1 原子性指的是什么意思?
 *       不可分割, 完整性.要么同时成功, 要么同时失败
 *   2.2 volatile是否可以保证原子性?
 *   2.3 why?
 *   2.4 如何解决?
 *   	2.4.1 sync
 *   	2.4.2 使用我们juc下的AtomicInteger
 * @author 000
 *
 */
public class VolatileDemo {
	public static void main(String[] args) {
		MyData myData = new MyData();
		for(int i=0; i<20; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					for(int j=0; j<1000; j++){
						myData.addPlusPlus();
						myData.addMyAtomic();
					}
					
				}
			},String.valueOf(i)).start();
		}
		while(Thread.activeCount() > 2){
			Thread.yield();
		}
		//如果volatile保证原子性, 则此时打印的值应该为20000!
		System.out.println(Thread.currentThread().getName() + "\t int type, finally number value: " + myData.number);
		System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type, finally number value: " + myData.atomicInteger);
		
	}
	
	//volatile可以保证可见性, 及时通知其它线程, 主物理内存的值已经修改
	public static void seeOKByVolatile() {
		MyData myData = new MyData();//资源类
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "\t" + "coming");
				//暂停一会线程
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myData.add();
				System.out.println(Thread.currentThread().getName() + "\t" + "updated number value: " + myData.number);
				
			}
		}, "AAA").start();
		
		//第二个线程是main线程
		while(myData.number == 0){
			
		}
		System.out.println(Thread.currentThread().getName() + "\t mission soluted");
	}
}
