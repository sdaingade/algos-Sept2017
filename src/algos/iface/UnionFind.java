package algos.iface;

public interface UnionFind {
  /* Add connection between p and q*/
  public void union(int p, int q);
  
  /* Are p and q the same component */
  public boolean connected(int p, int q);

  /* Get the number of connected components */
  public int countComponents();
  
  public void printState();
}
