package com.atguigu.Interview.thread;

import java.util.concurrent.atomic.AtomicReference;

public class SingletomCASDemo {
	private static final AtomicReference<SingletomCASDemo> INSTANCE = new AtomicReference<SingletomCASDemo>();
	
	private SingletomCASDemo(){
		System.out.println("执行构造器");
	}
	
	public static SingletomCASDemo getInstance(){
		for(;;){
			SingletomCASDemo demo = INSTANCE.get();
			if(null != demo){
				return demo;
			}
			
			demo = new SingletomCASDemo();
			
			if(INSTANCE.compareAndSet(null, demo)){
				return demo;
			}
			
		}
	}
	
	public static void main(String[] args) {
		for(int i=0; i<1000; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					SingletomCASDemo.getInstance();
					
				}
			}).start();
		}
	}

}
