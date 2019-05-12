package multithreading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMultiAndIO3 {
	public static void main(String[] args) {
		List<String> list1 = readTxt("C:\\Users\\000\\Desktop\\test01.txt");
		List<String> list2 = readTxt("C:\\Users\\000\\Desktop\\test02.txt");
		Test10 test = new Test10();
		new Thread(new Runnable(){
			public void run(){
				test.loopA(list1);
			}
		},"Read").start();
		new Thread(new Runnable(){
			public void run(){
				test.loopA(list2);
			}
		},"Write").start();
		
		
		
	}
	
	public static List<String> readTxt(String path){
		BufferedReader br = null;
		List<String> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(path));
			
			String str;
			while((str=br.readLine()) != null){
				list.add(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

class Test10 {
	
	private int num = 1;
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	
	public void loopA(List<String> list){
		if(num != 1){
			try {
				c1.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0; i<list.size(); i++){
			list.get(i);
			num = 2;
			c2.signal();
		}
	}
	public void loopB(List<String> list){
		if(num != 2){
			try {
				c2.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0; i<list.size(); i++){
			list.get(i);
			num = 1;
			c1.signal();
		}
	}
	
}





























