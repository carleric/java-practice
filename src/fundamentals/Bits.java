package fundamentals;

public class Bits {
	public int numOnesInBinary( int number ){
		int numOnes = 0;
		while(number != 0){
			if( (number & 1) == 1)
				numOnes ++;
			number = number >>> 1;//logical right shift inserts 0's at MSB (most significant bit)
		}
		return numOnes;
	}
	
	public boolean getBit(int num, int i){
		return ((num & (1 << i)) != 0);
	}
	
	public int setBit(int num, int i){
		return num | (1 << i);
	}
	
	public int clearBit(int num, int i){
		int mask = ~(1 << i);
		return num & mask;
	}
	
	public int clearBitsMSBthroughI(int num, int i){
		int mask = (1 << i) -1;
		return num & mask;
	}
	
	public int clearBitsIthrough0(int num, int i){
		int mask = ~((1 << (i+1)) -1);
		return num & mask;
	}
	
	public int updateBit(int num, int i, int v){
		int mask = ~(1 << i);
		return (num & mask) | (v << i);
	}
}
