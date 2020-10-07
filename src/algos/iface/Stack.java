package algos.iface;

public interface Stack<T> {
	public void push(T item) throws Exception;
	
	public T pop() throws Exception; 

	public boolean isEmpty() throws Exception;
	
	public int size() throws Exception;
}
