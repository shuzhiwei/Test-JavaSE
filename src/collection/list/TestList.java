package collection.list;

import java.util.HashMap;

public class TestList {
	public static void main(String[] args) {

		HashMap map = new HashMap();
		for(int i = 0; i<100; i++){
			map.put(new Data(i), "a" + i);
		}
		
		
	}
	
}

class Data{
	private int num;

	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Data(int num) {
		super();
		this.num = num;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
}