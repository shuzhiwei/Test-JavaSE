package multithreading;

import java.io.RandomAccessFile;

public class TestInputStream {
	public static void main(String[] args) throws Exception {
		/*FileInputStream fis = new FileInputStream("c://Users/000/Desktop/abc.txt");
		int len;
		byte[] buff = new byte[10];
		while((len=fis.read(buff)) != -1){
			System.out.println(new String(buff, 0, len));
		}
		fis.close();*/
		
		RandomAccessFile raf = new RandomAccessFile("c://Users/000/Desktop/abc.txt","rw");	
		raf.seek(0);
		byte[] buff = new byte[1000];
		int nextPos;
		while((nextPos=raf.read(buff)) != -1){
			System.out.println(new String(buff));
			System.out.println("a");
		}
		
	}

}
