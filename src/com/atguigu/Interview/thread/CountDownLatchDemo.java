package com.atguigu.Interview.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for(int i=1; i<=6; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "\t国, 被灭");
					countDownLatch.countDown();
				}
			},CountryEnum.foreach_countryEnum(i).getMessage()).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "****秦国, 一统天下****");
		
		
	}

	public static void closeDoor() {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for(int i=1; i<=6; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "\t 正在上自习");
					countDownLatch.countDown();
				}
			},String.valueOf(i)).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "****班长锁门****");
	}

}
