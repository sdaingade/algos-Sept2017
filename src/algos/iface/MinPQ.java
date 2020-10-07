package algos.iface;

public interface MinPQ<T extends Comparable<T>> {

	public void insert(T k) throws Exception;
	
	public T delMin() throws Exception;
	
	public boolean isEmpty();
	
	public T max();
	
	public int size();
}
