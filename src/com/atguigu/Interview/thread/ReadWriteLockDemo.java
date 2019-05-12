package com.atguigu.Interview.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;



class MyCache{
	private volatile Map<String, Object> map = new HashMap<>();
	ReadWriteLock rwLock = new ReentrantReadWriteLock();
	
	public void putData(String key, Object value ){
		rwLock.writeLock().lock();
		try{
			System.out.println(Thread.currentThread().getName() + "\t 开始写");
			map.put(key, value);
			System.out.println(Thread.currentThread().getName() + "\t 写完成");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			rwLock.writeLock().unlock();
		}
		
		
	}
	public void getData(String key){
		rwLock.readLock().lock();
		try{
			System.out.println(Thread.currentThread().getName() + "\t 开始读");
			map.get(key);
			System.out.println(Thread.currentThread().getName() + "\t 读完成");
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			rwLock.readLock().unlock();
		}
		
	}
}

/**
 * 多个线程同时读取一个资源类没有任何而问题, 所以为了满足并发量, 读取共享资源应该同时进行
 * 但是, 如果一个线程想去写共享资源, 就不应该再有其他线程对该共享资源进行读和写
 * @author Administrator
 *
 */
public class ReadWriteLockDemo {
	public static void main(String[] args) {
		MyCache myCache = new MyCache();
		
		for(int i=1; i<=10; i++){
			final int a = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					myCache.putData(a+"", a+"");
					
				}
			},i+"").start();
		}
		for(int i=1; i<=10; i++){
			final int a = i;
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					myCache.getData(a + "");
					
				}
			},i+"").start();
		}
	}
}
