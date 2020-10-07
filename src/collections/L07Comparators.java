package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		int l1 = arg0.length();
		int l2 = arg1.length();
		
		if(l1 < l2) return -1;
		else if (l1 > l2) return 1;
		else 	return 0;
	}

}

class ReverseAlphabeticalOrder implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2) * -1;
	}
}

class Person1 {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person1(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {
		return "[ id=" + id + ", name=" + name + "]";
	}
}

public class L07Comparators {

	public static void main(String[] args) {
		// Sorting strings
		
		List<String> animals = new ArrayList<String>();

		animals.add("dog");
		animals.add("cat");
		animals.add("parrot");
		animals.add("lion");
		animals.add("tiger");
		animals.add("snake");
		
		Collections.sort(animals);
		System.out.println("Natural order..."); // Natural order is defined by implementing the Comparable<String> interface
		for(String animal: animals) {
			System.out.println(animal);
		}
		
		// For using alternate orders for sorting we need to define Comparators like Comparator<String>
		Collections.sort(animals, new StringLengthComparator());
		System.out.println("Using StringLengthComparator...");
		for(String animal: animals) {
			System.out.println(animal);
		}
		
		Collections.sort(animals, new ReverseAlphabeticalOrder());
		System.out.println("Using ReverseAlphabeticalOrder...");
		for(String animal: animals) {
			System.out.println(animal);
		}
		
		// Sorting arbitrary objects
		List<Person1> people = new ArrayList<Person1>();
		people.add(new Person1(1, "Joe"));
		people.add(new Person1(2, "Bob"));
		people.add(new Person1(3, "Sue"));
		people.add(new Person1(4, "Clair"));

		// Sort in order of id
		System.out.println("Sort by id");		
		Collections.sort(people, new Comparator<Person1>() {

			@Override
			public int compare(Person1 p1, Person1 p2) {
				if (p1.getId() < p2.getId()) return -1;
				else if (p1.getId() > p2.getId()) return 1;
				else 	return 0;
			}

		});
		
		for (Person1 person: people) {
			System.out.println(person);
		}
		
		// Sort in order of name
		System.out.println("Sort by name");
		Collections.sort(people, new Comparator<Person1>() {
			public int compare(Person1 p1, Person1 p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});

		for (Person1 person: people) {
			System.out.println(person);
		}
	}

}
