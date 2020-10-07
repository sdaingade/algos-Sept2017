package bitmanipulation;

public class BitManipulationUtils {

	public static boolean getBit(int num, int i) {
		//  7 6 5 4 3 2 1 0
		//  0 0 0 0 0 0 0 1  = 1 
		//  0 0 1 0 0 0 0 0  = 1 << 5

		assert (i >=0 && i<32);
		return ((num & (1 << i)) != 0);
	}

	public static int setBit(int num, int i) {
		assert (i >=0 && i<32);
		return (num | (1 << i));
	}

	public static int clearBit(int num, int i) {
		//  7 6 5 4 3 2 1 0
		//  0 0 0 0 0 0 0 1  = 1 
		//  0 0 1 0 0 0 0 0  = 1 << 5
		//  1 1 0 1 1 1 1 1  = ~(1 << 5)

		assert (i >=0 && i<32);
		int mask = ~(1 << i);
		return (num & mask);
	}

	int clearBitsMSBthroughI(int num, int i) {
		int mask = ((1 << i) - 1);
		return (num & mask);
	}

	int clearBitsIthrough0(int num, int i) {
		//  7 6 5 4 3 2 1 0
		//  0 0 0 0 0 0 0 1  = 1 
		//  0 1 0 0 0 0 0 0  = 1 << (5 + 1)
		//  0 0 1 1 1 1 1 1  = (1 << (5 + 1)) - 1
		//  1 1 0 0 0 0 0 0  = ~((1 << (5 + 1)) - 1)
		
		int mask = ~((1 << (i+1)) -1);
		return (mask & num);
	}

	public static int updateBit(int num, int pos, int val) {
		assert (val==0 || val == 1);
		assert (pos>=0 && pos < 32);

		int mask = ~(1 << pos);
		return (num & mask) | (val << pos);
	}
	
}
