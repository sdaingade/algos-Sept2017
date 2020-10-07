package collections;

import java.util.HashMap;
import java.util.Map;

public class L03HashMap {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "One");
		map.put(5, "Five");
		map.put(4, "Four");
		map.put(2, "Two");

		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		for (Integer key: map.keySet()) {
			System.out.println("Key: " + key + ", Value: " + map.get(key));
		}
	}

}

