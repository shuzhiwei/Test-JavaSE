package map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMap {
	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> map = new HashMap<>();
		File file = new File("C:/Users/000/Desktop/test01.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str;
		while((str=br.readLine()) != null){
			String[] splits = str.split(" ");
			for (String s : splits) {
				if(map.containsKey(s)){
					map.put(s, map.get(s)+1);
				}else{
					map.put(s, 1);
				}
			}
		}
		/*Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + ":" + value);
			
		}*/
		
		List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				return o2.getValue() - o1.getValue();
			}
			
		});
		
		
		for (Entry<String, Integer> entry : list) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		Entry<String, Integer> entry = list.get(0);
		System.out.println(entry.getKey() + ":" + entry.getValue());
		
		
		
	}
}
