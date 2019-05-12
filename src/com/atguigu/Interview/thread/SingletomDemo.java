package com.atguigu.Interview.thread;

public class SingletomDemo {
	private static volatile SingletomDemo instance = null;
	private SingletomDemo(){
		System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletomDemo()");
	}
	
	//DCL(Double Check Lock双端检锁机制)即加锁的前后加上判断
	public static SingletomDemo getInstance(){
		if(instance == null){
			synchronized(SingletomDemo.class){
				if(instance == null){
					instance = new SingletomDemo();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		/*System.out.println(SingletomDemo.getInstance() == SingletomDemo.getInstance());
		System.out.println(SingletomDemo.getInstance() == SingletomDemo.getInstance());
		System.out.println(SingletomDemo.getInstance() == SingletomDemo.getInstance());*/
		
		for(int i=0; i<10; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					SingletomDemo.getInstance();
					
				}
			},String.valueOf(i)).start();
			
		}
	}
}
