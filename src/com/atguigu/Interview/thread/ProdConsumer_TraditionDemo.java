package com.atguigu.Interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
	private int number = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void incement() throws Exception{
		lock.lock();
		try{
			while(number != 0){
				condition.await();
			}
			number++;
			System.out.println(Thread.currentThread().getName() +"\t" + number);
			//通知唤醒
			condition.signalAll();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	public void decement() throws Exception{
		lock.lock();
		try{
			while(number == 0){
				condition.await();
			}
			number--;
			System.out.println(Thread.currentThread().getName() +"\t" + number);
			//通知唤醒
			condition.signalAll();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
}

public class ProdConsumer_TraditionDemo{
	public static void main(String[] args) {
		ShareData shareData = new ShareData();
		for(int i=1; i<=5; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						shareData.incement();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			},"AA").start();
		}
		for(int i=1; i<=5; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						shareData.decement();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			},"BB").start();
		}
		for(int i=1; i<=5; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						shareData.incement();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			},"CC").start();
		}
		for(int i=1; i<=5; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						shareData.decement();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			},"DD").start();
		}
		
		
	}
}

