package algos.iface;

public interface MaxPQ<T extends Comparable<T>> {

	public void insert(T k);
	
	public T delMax();
	
	public boolean isEmpty();
	
	public T max();
	
	public int size();
	
	public void printElements();
}
