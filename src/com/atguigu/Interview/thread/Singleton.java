package com.atguigu.Interview.thread;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton {
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<Singleton>(); 

    private Singleton() {
    	System.out.println("执行构造器");
    }

    public static Singleton getInstance() {
        for (;;) {
            Singleton singleton = INSTANCE.get();
            if (null != singleton) {
                return singleton;
            }

            singleton = new Singleton();
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
    
    public static void main(String[] args) {
    	for(int i=0; i<10000; i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Singleton.getInstance();
					
				}
			}).start();
		}
	}
}
