package test;

import java.util.concurrent.atomic.AtomicReference;

public class Test03 {
	private static AtomicReference<Test03> a = new AtomicReference<Test03>();
	
	private Test03(){
		System.out.println("执行构造器");
	}
	
	public static Test03 getInstance(){
		Test03 b = null;
		Test03 c = null;
		do {
			b = a.get();
			if(b == null){
				c = new Test03();
			}
			
		} while (!a.compareAndSet(b, c));
		return a.get();
	}
	public static void main(String[] args) {
		for(int i=0; i<100; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Test03.getInstance();
					
				}
			}).start();
		}
		
		
	}

}
