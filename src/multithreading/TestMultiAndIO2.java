package multithreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class TestMultiAndIO2 {
	public static void main(String[] args) {
		
	}
}

class TestIO{
	private StringBuilder sb = new StringBuilder();
	
	public synchronized void testIO(String path) throws Exception {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str;
		while((str=br.readLine()) != null){
			sb.append(str).append("-->");
			this.notify();
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
