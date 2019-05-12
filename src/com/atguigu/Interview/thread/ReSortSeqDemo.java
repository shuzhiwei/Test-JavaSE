package com.atguigu.Interview.thread;

public class ReSortSeqDemo {
	 static volatile ReSortSeqDemo instance = null;
	 int a=0;
	 boolean flag = false;
	 public static ReSortSeqDemo getInstance(){
		 if(instance == null){
			 synchronized(ReSortSeqDemo.class){
				 if(instance == null){
					 instance = new ReSortSeqDemo();
				 }
			 }
		 }
		 return instance;
	 }
	
	public synchronized void method1(){
		a=1;			//语句1
		flag = true;	//语句2
	}
	
	/**
	 * 多线程环境中线程交替执行, 由于编译器优化重排的存在, 两个线程中使用的变量能否保持一致并不确定
	 * 使用volatile可以禁止指定重排
	 */
	public synchronized void method2(){
		if(flag){
			a = a+5;	//语句3
			System.out.println(a);
			flag = false;
		}
	}
	
	public static void main(String[] args) {
		ReSortSeqDemo demo =ReSortSeqDemo.getInstance();
		for(int i=0; i<100; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					demo.method1();
				}
			},"AAA").start();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					demo.method2();
				}
			},"BBB").start();
		}
		
		
	}
}
