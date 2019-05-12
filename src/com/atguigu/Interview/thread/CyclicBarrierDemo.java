package com.atguigu.Interview.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("**********召唤神龙");
			}
		});
		
		for(int i=1; i<=7; i++){
			final int a = i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("收集到第" + a + "颗龙珠");
					try {
						cyclicBarrier.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
				}
			}, String.valueOf(a)).start();
		}
		
	}
}
