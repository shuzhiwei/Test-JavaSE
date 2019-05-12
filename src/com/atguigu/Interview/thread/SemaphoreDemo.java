package com.atguigu.Interview.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(3);
		for(int i=1; i<=6; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName() + "\t抢到车位");
						TimeUnit.SECONDS.sleep(3);
						System.out.println(Thread.currentThread().getName() + "\t停车3秒后,离开车位");
						semaphore.release();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			},String.valueOf(i)).start();
		}
	}
}
