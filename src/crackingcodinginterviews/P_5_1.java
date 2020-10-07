package crackingcodinginterviews;

public class P_5_1 {

	/*
	 *  
	 */
	public static int updateBits(int N, int M, int i, int j) {
		int allOnes = ~0;
		
		int leftMask = (allOnes << j+1);

		int rightMask = (1 << i) -1;

		int mask = leftMask | rightMask;

		int m_shifted = (M << i);
		int n_cleared = N & mask;
		return (n_cleared | m_shifted);
	}
	
	public static void main(String[] args) {
		//Eg: N=10000000000 M=10011, i=2, j=6
		
	}

}
