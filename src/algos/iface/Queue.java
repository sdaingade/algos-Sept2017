package algos.iface;

public interface Queue<T> {
	public void enqueue(T item) throws Exception;
	
	public T dequeue() throws Exception;

	public boolean isEmpty() throws Exception;

}
