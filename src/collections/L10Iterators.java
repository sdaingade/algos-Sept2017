package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class L10Iterators {

	public static void main(String[] args) {
		LinkedList<String> animals = new LinkedList<String>();

		animals.add("fox");
		animals.add("cat");
		animals.add("dog");
		animals.add("rabbit");
		
/*
 * Java.lang.Iterable
 * 
 * public interface Iterable<Type> {
 * 		Iterator<Type> iterator();
 * }
 * 
 * Java.lang.Iterator
 * 
 * public interface Iterator<Type> {
 * 		public boolean hasNext();
 * 		public Type next();
 * 		public void remove(); 
 * }
 */
		
		Iterator<String> it = animals.iterator();
		while(it.hasNext()) {
			String value = it.next();
			System.out.println(value);

			if(value.equals("cat"))
				it.remove();
		}
		// To add elements to a List while iterating use ListIterator (see java.util.ListIterator) 
		

		System.out.println();

		// Modern iteration, Java 5 and later.
		for(String animal: animals) {
			System.out.println(animal);
			// animals.remove(); Does not work. Fails with ConcurrentModificationException.
			// If you want to remove items from a list while iterating through them you have to use an iterator.
		}
	}

}
