package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class L05Sets {

	public static void main(String[] args) {
		// Set do not have duplicate values
		// Adding a duplicate values has no impact
		// Useful for eliminating duplicates
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new LinkedHashSet<String>();
		Set<String> set3 = new TreeSet<String>();
		
		set1.add("dog");
		set1.add("cat");
		set1.add("mouse");
		set1.add("snake");
		set1.add("parrot");
		set1.add("dog"); // Adding duplicate has no impact
		System.out.println("HashSet:" + set1); //Maintains no order
		
		set2.add("dog");
		set2.add("cat");
		set2.add("mouse");
		set2.add("snake");
		set2.add("parrot");
		set2.add("dog"); // Adding duplicate has no impact
		System.out.println("LinkedHashSet:" + set2); //Maintains order of insertion
		
		set3.add("dog");
		set3.add("cat");
		set3.add("mouse");
		set3.add("snake");
		set3.add("parrot");
		set3.add("dog"); // Adding duplicate has no impact
		System.out.println("TreeSet:" + set3);//Maintains sorted order
		
		//Iteration
		System.out.println("Iteration....");
		for(String item: set1) {
			System.out.println(item);
		}
		//Does set contain a given item
		if(set1.contains("cat"))
			System.out.println("Contains cat...");
		
		if(set1.contains("aadvark"))
			System.out.println("Contains aadvark...");
		
		//empty
		if(set1.isEmpty())
			System.out.println("Set1 is empty...");
		// size
		// isEmpty()
		// contains
		// add
		// remove
		// iterator
		
		//Set Intersection : What's common between set1 and set4
		Set<String> set4 = new TreeSet<String>();
		set4.add("dog");
		set4.add("cat");
		set4.add("horse");
		set4.add("lion");
		set4.add("tiger");
		set4.add("monkey");
		
		Set<String> intersection = new HashSet<String>(set1);
		//Make intersection a copy of set1
		
		System.out.println("Intersetion: " + intersection);
		System.out.println("Set4: " + set4);
		intersection.retainAll(set4); //REtains only those elements in 'intersection' that are contained in set1
		System.out.println("Interstion with Set4:" + intersection);
		
		//Set Difference: What's in set1 that not in set4
		Set<String> difference = new HashSet<String>(set1);
		difference.removeAll(set4);
		System.out.println("Difference with Set4:" + difference);
		
		
	}
}
