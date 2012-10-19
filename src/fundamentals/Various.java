package fundamentals;

public class Various {
	
	public static int fib(int n){
		if(n <= 2)
			return n;
		else
			return fib(n-1) + fib(n-2);
	}
	
	/**
	 * Given two light bulbs and a building with x stories,
	 * find the exact height(number of floors) of the building where
	 * the light bulb breaks, using the minimal number of
	 * drops.
	 */
	public static int[] findBreakingHeight(int floors, Bulb bulb){
		//optimal first drop height the first increment
		//of a sum of gradually decreasing increments that 
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
	
}
