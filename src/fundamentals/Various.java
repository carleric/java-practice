package fundamentals;

import java.util.ArrayList;
import java.util.Arrays;

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
		private final int breakingHeight;

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



	public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        // we make an array with the length of the input array to
        // hold our products
        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];

        // for each integer, we find the product of all the integers
        // before it, storing the total product so far each time
        int productSoFar = 1;
        for (int i=0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar *= intArray[i];
        }

        // for each integer, we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for (int i = intArray.length - 1; i>=0; i--) {
            productsOfAllIntsExceptAtIndex[i] *= productSoFar;
            productSoFar *= intArray[i];
        }

        return productsOfAllIntsExceptAtIndex;
    }

	/**
	 *
	 * Given an arrayOfInts, find the highestProduct you can get from three of the integers.
	 * The input arrayOfInts will always have at least three integers.
	 * example: {-10, -10, 1, 3, 2}
	 * taken from https://www.interviewcake.com/question/java/highest-product-of-3
	 */
	public static int highestProductOf3(int[] arrayOfInts) {
	    if (arrayOfInts.length < 3) {
	        throw new IllegalArgumentException("Less than 3 items!");
	    }

	    // We're going to start at the 3rd item (at index 2)
	    // so pre-populate highests and lowests based on the first 2 items.
	    // we could also start these as null and check below if they're set
	    // but this is arguably cleaner
	    int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
	    int lowest  = Math.min(arrayOfInts[0], arrayOfInts[1]);

	    int highestProductOf2 = arrayOfInts[0] * arrayOfInts[1];
	    int lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];

	    // except this one--we pre-populate it for the first /3/ items.
	    // this means in our first pass it'll check against itself, which is fine.
	    int highestProductOf3 = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

	    // walk through items, starting at index 2
	    for (int i=2; i < arrayOfInts.length; i++) {
	        int current = arrayOfInts[i];

	        // do we have a new highest product of 3?
	        // it's either the current highest,
	        // or the current times the highest product of two
	        // or the current times the lowest product of two
	        highestProductOf3 = Math.max(Math.max(
	            highestProductOf3,
	            current * highestProductOf2),
	            current * lowestProductOf2);

	        // do we have a new highest product of two?
	        highestProductOf2 = Math.max(Math.max(
	            highestProductOf2,
	            current * highest),
	            current * lowest);

	        // do we have a new lowest product of two?
	        lowestProductOf2 = Math.min(Math.min(
	            lowestProductOf2,
	            current * highest),
	            current * lowest);

	        // do we have a new highest?
	        highest = Math.max(highest, current);

	        // do we have a new lowest?
	        lowest = Math.min(lowest, current);
	    }

	    return highestProductOf3;
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

			if(item.length() != expression.length())
				break;//not a match if the item isn't the same length as the test expression

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
