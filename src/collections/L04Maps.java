package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class L04Maps {

	
	public static void main(String[] args) {
		Map<Integer, String> map1 = new HashMap<Integer, String>(); // Does not retain Order
		Map<Integer, String> map2 = new LinkedHashMap<Integer, String>(); //Maintains order of insertion
		Map<Integer, String> map3 = new TreeMap<Integer, String>(); // Maintains sorted order of keys
		
		map1.put(1, "apple");
		map1.put(5, "banana");
		map1.put(3, "mango");
		map1.put(7, "peach");
		map1.put(2, "pineapple");
		
		map2.put(1, "apple");
		map2.put(5, "banana");
		map2.put(3, "mango");
		map2.put(7, "peach");
		map2.put(2, "pineapple");
		
		map3.put(1, "apple");
		map3.put(5, "banana");
		map3.put(3, "mango");
		map3.put(7, "peach");
		map3.put(2, "pineapple");
		
		testMap("HashMap", map1);
		testMap("LinkedHashMap", map2);
		testMap("TreeMap", map3);
	}
	
	public static void testMap(String type, Map<Integer, String> map) {
		System.out.println("Map Type: " + type);
		for(Integer key: map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
	}
}
