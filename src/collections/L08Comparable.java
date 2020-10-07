package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Person2 implements Comparable<Person2>{
	private String name;
	
	public Person2(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Person2 that) {
		return this.name.compareTo(that.name);
	}
	
	//This implementation of compareTo would be problematic in Maps and Sets as same length
	// name strings would evaluate as equal and Maps and Sets cannot have duplicate entries
	// Ideally there should be no mismatch between compareTo and equals()

	/*
	@Override
	public int compareTo(Person2 that) {
		int len1 = name.length();
		int len2 = that.name.length();
		
		if (len1 < len2) return -1;
		else if (len1 > len2) return 1;
		else return 0; // change to name.compareTo(that.name)
	}
	*/

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person2 other = (Person2) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return name;
	}
}

public class L08Comparable {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Set<String> set = new TreeSet<String>();
		
		addElements(list);
		addElements(set);
		
		// For comparing custom types like Person2 we need to implement the Comparable<Person2> interface
		// This defines natural order for the custom type like Person2

		Collections.sort(list);
		displayElements(list);
		System.out.println();
		displayElements(set);

		List<Person2> pList = new ArrayList<Person2>();
		Set<Person2> pSet = new TreeSet<Person2>();

		addPersons(pList);
		addPersons(pSet);

		System.out.println();
		System.out.println("Custom Object");
		Collections.sort(pList);
		displayPersons(pList);

		System.out.println();
		displayPersons(pSet);
		
	}

	public static void addElements(Collection<String> collection) {
		collection.add("Adam");
		collection.add("Joe");
		collection.add("Alex");
		collection.add("Phil");
		collection.add("Luke");
	}
	
	public static void displayElements(Collection<String> collection) {
		for(String item: collection)
			System.out.println(item);
	}
	
	public static void addPersons(Collection<Person2> collection) {
		collection.add(new Person2("Adam"));
		collection.add(new Person2("Joe"));
		collection.add(new Person2("Alex"));
		collection.add(new Person2("Phil"));
		collection.add(new Person2("Luke"));
	}

	public static void displayPersons(Collection<Person2> collection) {
		for(Person2 item: collection)
			System.out.println(item);
	}
	
}
