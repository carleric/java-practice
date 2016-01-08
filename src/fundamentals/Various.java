package fundamentals;

public class Various {
	
	public static int fib(int n){
		if(n <= 2)
			return n;
		else
			return fib(n-1) + fib(n-2);
	}
	
	public static boolean isPrimeNaive(int num){
		if(num < 2)
			return false;
		for(int i=2; i<num; i++){
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean isPrimeBetter(int num){
		if(num < 2)
			return false;
		int sqrt = (int)Math.sqrt(num);
		for(int i=2; i<sqrt; i++){
			if(num % i == 0)
				return false;
		}
		return true;
	}
	
	public static boolean [] sieveOfEratosthenes(int max){
		boolean [] flags = new boolean[max];
		int count = 0;
		
		init(flags);
		int prime = 2;
		
		while(prime <= max){
			crossOff(flags, prime);
			
			prime = getNextPrime(flags, prime);
			
			if (prime >= flags.length)
				break;
		}
		
		return flags;
	}
	
	private static void init(boolean [] flags){
		for(int i=2; i<flags.length; i++){
			flags[i] = true;
		}
	}
	
	private static void crossOff(boolean [] flags, int prime){
		for(int i=prime*prime; i < flags.length; i += prime){
			flags[i] = false;
		}
	}
	
	private static int getNextPrime(boolean [] flags, int prime){
		int next = prime + 1;
		while (next < flags.length && !flags[next]){
			next++;
		}
		return next;
	}
	
	/**
	 * Given two light bulbs and a building with x stories,
	 * find the exact height(number of floors) of the building where
	 * the light bulb breaks, using the minimal number of
	 * drops.
	 */
	public static int[] findBreakingHeight(int floors, Bulb bulb){
		//optimal first drop height is the first increment
		//of a sum of decreasing increments that 
		//are just greater than the building height
		int sum = 0;
		int dropIncrement = 0;
		int numDrops = 0;
		do{
			dropIncrement++;
			sum += dropIncrement;
		}while(sum < floors);
		
		//first bulb
		int firstDropFloor = dropIncrement;
		while(firstDropFloor < floors){
			numDrops ++;
			if(bulb.breaks(firstDropFloor))
				break;
			dropIncrement --; 
			firstDropFloor = firstDropFloor + dropIncrement;
			
		}
		
		//second bulb
		int secondDropFloor = firstDropFloor - (dropIncrement-1);
		while(secondDropFloor < firstDropFloor){
			numDrops ++;
			if(bulb.breaks(secondDropFloor))
				break;
			secondDropFloor ++;
			
		}
		int [] answer = {secondDropFloor, numDrops};
		return answer;
	}
	
	private static class Bulb{
		private int breakingHeight;
		
		public Bulb(int breakingHeight){
			this.breakingHeight = breakingHeight;
		}
		
		public boolean breaks(int dropHeight){
			return dropHeight >= this.breakingHeight;
		}
	}
	
	public static Bulb makeBulb(int breakingHeight){
		return new Bulb(breakingHeight);
	}
	
	/**
	 * Given an array of strings and a text expression, return true if any of the items in the array
	 * matches the expression. '.' chars in the expression indicate a wild card
	 * @param stringArray
	 * @param expression
	 * @return true if any matches are found
	 */
	public static boolean hasMatch(String [] stringArray, String expression) {


		//for each item in collection
		for (int i = 0; i <  stringArray.length; i++) {
			String item = stringArray[i];

			int matchingCharCount = 0;

			//for each char in item
			for (int j = 0; j < item.length(); j++) {
				Character ch = item.charAt(j);
				if(ch == expression.charAt(j) || expression.charAt(j) == '.') {
					matchingCharCount++;
				}
			}

			if (matchingCharCount == expression.length()) {
				return true;
			}
		}
		return false;
	}
}
