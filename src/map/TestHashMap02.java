package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class TestHashMap02 {
	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		FileReader fr = new FileReader("C:/Users/000/Desktop/test01.txt");
		//FileWriter fw = new FileWriter("C:/Users/000/Desktop/result01.txt");
		
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw0 = new FileWriter("C:/Users/000/Desktop/0.txt");
		FileWriter fw1 = new FileWriter("C:/Users/000/Desktop/1.txt");
		FileWriter fw2 = new FileWriter("C:/Users/000/Desktop/2.txt");
		FileWriter fw3 = new FileWriter("C:/Users/000/Desktop/3.txt");
		String str;
		while((str=br.readLine()) != null){
			String[] splits = str.split(" ");
			for (String s : splits) {
				int i = Integer.parseInt(s);
				int a = i % 4;
				if(a == 0){
					String ss = s + " ";
					fw0.append(ss);
					fw0.flush();
				}
				if(a == 1){
					String ss = s + " ";
					fw1.append(ss);
					fw1.flush();
				}
				if(a == 2){
					String ss = s + " ";
					fw2.append(ss);
					fw2.flush();
				}
				if(a == 3){
					String ss = s + " ";
					fw3.append(ss);
					fw3.flush();
				}
				
			}
		}
		
		fw0.close();
		fw1.close();
		fw2.close();
		fw3.close();
		br.close();
		
	}
		
}
