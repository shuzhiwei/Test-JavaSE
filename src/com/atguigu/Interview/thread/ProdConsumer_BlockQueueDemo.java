package com.atguigu.Interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.omg.Messaging.SyncScopeHelper;

class MyResource{
	private volatile boolean FLAG = true;//默认开启, 进行生产+消费
	private AtomicInteger atomicInteger = new AtomicInteger();
	
	BlockingQueue<String> blockingQueue = null;
	
	public MyResource(BlockingQueue<String> blockingQueue){
		this.blockingQueue = blockingQueue;
		System.out.println(blockingQueue.getClass().getName());
	}
	
	public void myProd() throws Exception{
		String data = null;
		boolean retValue;
		while(FLAG){
			data = atomicInteger.incrementAndGet() + "";
			retValue = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
			if(retValue){
				System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "成功");
			}else{
				System.out.println(Thread.currentThread().getName() + "\t插入队列" + data + "失败");
			}
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println(Thread.currentThread().getName() + "\t大老板叫停了, 表示FLAG=false, 生产动作结束");
		
	}
	
	public void myConsumer() throws Exception{
		String result = null;
		while(FLAG){
			result = blockingQueue.poll(2, TimeUnit.SECONDS);
			if(null == result || result.equalsIgnoreCase("")){
				FLAG = false;
				System.out.println(Thread.currentThread().getName() + "\t 超过2秒钟没有取到蛋糕, 消费退出");
				System.out.println();
				System.out.println();
				return;
			}
			System.out.println(Thread.currentThread().getName() + "\t消费队列蛋糕" + result + "成功");
		}
	}
	
	public void stop() throws Exception{
		this.FLAG = false;
		
	}
	
	
}

public class ProdConsumer_BlockQueueDemo {
	public static void main(String[] args) throws Exception {
		MyResource myResource = new MyResource(new ArrayBlockingQueue<>(6));
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("生产线程启动");
				try {
					myResource.myProd();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"Prod").start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("消费线程启动");
				System.out.println();
				System.out.println();
				try {
					myResource.myConsumer();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		},"Consumer").start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("5秒时间到, 大老板main线程叫停, 活动结束");
		myResource.stop();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
