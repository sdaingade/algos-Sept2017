package algos.impl;

import java.io.InputStream;
import java.util.LinkedList;

public class Graph {
	private final int V;
	private LinkedList<Integer>[] adj;

	public Graph(int V){
		this.V = V;
		this.adj = (LinkedList<Integer>[]) new Object[V];

		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>(); 
		}
	}

	/*public Graph(InputStream in){
		
	}*/
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}

	public Iterable<Integer> adj(int v){
		return adj[v];
	}

	public int V(){
		return V;
	}
	
	public int E(){
		return 0;
	}

	@Override
	public String toString(){
		return null;
	}
	
}
