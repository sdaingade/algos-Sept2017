package collections;

import java.util.HashMap;
import java.util.Map;

class Person {
	private int id;
	private String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// Goto Source >> Generate hashCode() and equals()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String toString() {
		return "[id = " + id + ", name = " + name + "]";
	}
}

public class L06UsingOwnObjects {

	public static void main(String[] args) {

		Map<Person, Integer> map = new HashMap<Person, Integer>();
		
		map.put(new Person(1, "Adam"), 1);
		map.put(new Person(1, "Adam"), 1);

		//Without hashCode() and equals() method, the map will have 2 entries both with Person(1, "Adam") as the key.
		// After the hashCode and equals() methods are added, there will one be 1 entry. 
		// Map and Set use the hashCode() and equals() methods for uniqueness

		for(Person person: map.keySet()) {
			System.out.println(person + ", " + map.get(person));
		}
		
	}
}
