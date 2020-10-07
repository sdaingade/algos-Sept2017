package algos.iface;

public class Node<T> {
	private T item;
	private Node<T> next;

	public Node(T item, Node<T> next) {
		this.item = item;
		this.next = next;
	}
	
	public T getItem() {
		return this.item;
	}
	
	public void setItem(T item) {
		this.item = item;
	}

	public Node<T> getNext() {
		return this.next;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
