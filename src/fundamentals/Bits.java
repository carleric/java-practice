package fundamentals;

public class Bits {
	public static int numOnesInBinary( int number ){
		int numOnes = 0;
		while(number != 0){
			if( (number & 1) == 1)
				numOnes ++;
			number = number >>> 1;//logical right shift inserts 0's at MSB (most significant bit)
		}
		return numOnes;
	}
	
	public static boolean getBit(int num, int i){
		return ((num & (1 << i)) != 0);
	}
	
	public static int setBit(int num, int i){
		return num | (1 << i);
	}
	
	public static int clearBit(int num, int i){
		int mask = ~(1 << i);
		return num & mask;
	}
	
	public static int clearBitsMSBthroughI(int num, int i){
		int mask = (1 << i) -1;
		return num & mask;
	}
	
	public static int clearBitsIthrough0(int num, int i){
		int mask = ~((1 << (i+1)) -1);
		return num & mask;
	}
	
	public static int updateBit(int num, int i, int v){
		int mask = ~(1 << i);
		return (num & mask) | (v << i);
	}
}
