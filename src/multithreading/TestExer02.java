package multithreading;

//练习: 程序按序交替
//编写一个程序,开启3个线程,这三个线程的 ID 分别为 A, B, C, 每个线程将自己的 ID 在屏幕上打印10遍,
//要求输出的结果必须按顺序显示:
//如: ABCABCABC... 依次递归

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestExer02 {
 public static void main(String[] args) {
     final ExerDemo1 exerDemo = new ExerDemo1();
     new Thread(new Runnable() {
         public void run() {
             for(int i = 1; i <= 10; i++){
                 exerDemo.loopA(i);
             }
         }
     }, "A").start();

     new Thread(new Runnable() {
         public void run() {
             for(int i = 1; i <= 10; i++){
                 exerDemo.loopB(i);
             }
         }
     }, "B").start();

     new Thread(new Runnable() {
         public void run() {
             for(int i = 1; i <= 10; i++){
                 exerDemo.loopC(i);
             }
         }
     }, "C").start();
 }
}

class ExerDemo1{
 private int num = 1;
 private Lock lock = new ReentrantLock();
 private Condition condition1 = lock.newCondition();
 private Condition condition2 = lock.newCondition();
 private Condition condition3 = lock.newCondition();

 public void loopA(int totalLoop){
     lock.lock();
     try{
         if(num != 1){
             try {
                 condition1.await();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         for(int i = 1; i <= 1; i++){
             System.out.print(Thread.currentThread().getName());
         }
         num = 2;
         condition2.signal();
     }finally {
         lock.unlock();
     }

 }

 public void loopB(int totalLoop){
     lock.lock();
     try{
         if(num != 2){
             try {
                 condition2.await();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         for(int i = 1; i <= 1; i++){
             //System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
             System.out.print(Thread.currentThread().getName());
         }
         num = 3;
         condition3.signal();
     }finally {
         lock.unlock();
     }

 }

 public void loopC(int totalLoop){
     lock.lock();
     try{
         if(num != 3){
             try {
                 condition3.await();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         for(int i = 1; i <= 1; i++){
             //System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
             System.out.print(Thread.currentThread().getName());
         }
         num = 1;
         condition1.signal();
     }finally {
         lock.unlock();
     }

 }
}

