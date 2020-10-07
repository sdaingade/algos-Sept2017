package algos.clients;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import algos.iface.UnionFind;
import algos.impl.QuickFindImpl;
import algos.impl.QuickUnionImpl;
import algos.impl.WeightedQuickUnionImpl;

public class UnionFindClient {

	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			String fileName = "UnionFind.txt";
			reader = new BufferedReader(new FileReader(fileName));

			int nodeCount = Integer.parseInt(reader.readLine());
			System.out.println("nodeCount:" + nodeCount);

			//UnionFind uf = new QuickFindImpl(nodeCount);
			//UnionFind uf = new QuickUnionImpl(nodeCount);
			UnionFind uf = new WeightedQuickUnionImpl(nodeCount);

			int connectionCount = Integer.parseInt(reader.readLine());
			System.out.println("conectionCount:" + connectionCount);
			
			for (int i=0; i< connectionCount; i++) {
				String [] numbers = reader.readLine().split(" ");

				if (numbers.length != 2)
					continue;
				
				int p = Integer.parseInt(numbers[0]);
				int q = Integer.parseInt(numbers[1]);
				
				if(!uf.connected(p, q)) {
					System.out.println("Connecting p: " + p + " and q: " + q) ;
					uf.union(p, q);
				} else {
					System.out.println("Already connected p: " + p + " and q: " + q) ;
				}

				uf.printState();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
