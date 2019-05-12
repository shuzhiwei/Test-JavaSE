package multithreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import org.junit.Test;


public class TestMultiAndIO {
	private StringBuilder sb = new StringBuilder();
	
	
	public synchronized void testIO(String path) throws Exception {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str;
		while((str=br.readLine()) != null){
			sb.append(str).append("-->");
			this.wait();
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
	@Test
	public void test01() throws Exception {
		File file = new File("C:\\Users\\000\\Desktop\\test01.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String str;
		while((str=br.readLine()) != null){
			sb.append(str);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	@Test
	public void test02() throws Exception {
		File file = new File("C:\\Users\\000\\Desktop\\test02.txt");
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String str;
		while((str=br.readLine()) != null){
			sb.append(str);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	@Test
	public void test03() throws Exception {
		File file = new File("C:\\Users\\000\\Desktop\\test01.txt");
		FileInputStream fis = new FileInputStream(file);
		StringBuilder sb = new StringBuilder();
		byte[] arr = new byte[1024];
		int len;
		while((len=fis.read(arr)) != -1){
			sb.append(new String(arr, 0, len));
		}
		System.out.println(sb.toString());
	}

}
