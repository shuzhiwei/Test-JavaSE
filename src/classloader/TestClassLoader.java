package classloader;

import java.util.ArrayList;
import java.util.List;

public class TestClassLoader {
	private byte[] arr = new byte[1024*1024];
	public static void main(String[] args){
		
		List<TestClassLoader> list = new ArrayList<>();
		try {
			for(int i=0; i<40; i++){
				list.add(new TestClassLoader());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		long maxMemory = Runtime.getRuntime().maxMemory();
		long totalMemory = Runtime.getRuntime().totalMemory();
		System.out.println("JVM最大内存: " + maxMemory/1024/1024 + "MB");
		System.out.println("JVM初始内存: " + totalMemory/1024/1024 + "MB");
		
	}
	
	/*public static void main(String[] args) {
		long maxMemory = Runtime.getRuntime().maxMemory();
		long totalMemory = Runtime.getRuntime().totalMemory();
		System.out.println("JVM最大内存: " + maxMemory/1024/1024 + "MB");
		System.out.println("JVM初始内存: " + totalMemory/1024/1024 + "MB");
	}*/
	
	
}
