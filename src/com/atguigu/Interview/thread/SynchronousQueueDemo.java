package com.atguigu.Interview.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {
	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread().getName() + "\t put 1");
					blockingQueue.put("1");
					System.out.println(Thread.currentThread().getName() + "\t put 2");
					blockingQueue.put("2");
					System.out.println(Thread.currentThread().getName() + "\t put 3");
					blockingQueue.put("3");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"A").start();
new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.println(Thread.currentThread().getName() + "\t  1");
					blockingQueue.take();
					TimeUnit.SECONDS.sleep(5);
					System.out.println(Thread.currentThread().getName() + "\t  2");
					blockingQueue.take();
					TimeUnit.SECONDS.sleep(5);
					System.out.println(Thread.currentThread().getName() + "\t  3");
					blockingQueue.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"B").start();
	}
}
