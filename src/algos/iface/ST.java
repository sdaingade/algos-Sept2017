package algos.iface;

public interface ST<Key extends Comparable<Key>, Value> {

	public void put(Key key, Value value); //overwrite old value with new

	public Value get(Key key); // Returns null if key not in table

	public void delete(Key key);

	public boolean contains(Key key);

	public boolean isEmpty();

	public int size();
	
	public Key floor(Key key);
	
	public int rank(Key key);
	
	//Iterable<Key> keys();
}
