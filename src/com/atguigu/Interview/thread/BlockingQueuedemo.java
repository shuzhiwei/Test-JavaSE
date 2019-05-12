package com.atguigu.Interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 1 队列
 * 2 阻塞队列
 * 	2.1 阻塞队列有没有好的一面
 * 	2.2 不得不阻塞, 你如何管理
 * @author Administrator
 *
 */
public class BlockingQueuedemo {
	public static void main(String[] args) {
		//抛出异常组
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
		System.out.println(blockingQueue.add("a"));
		System.out.println(blockingQueue.add("b"));
		System.out.println(blockingQueue.add("c"));
		
		System.out.println(blockingQueue.element());
		
		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
		System.out.println(blockingQueue.remove());
	}
}
