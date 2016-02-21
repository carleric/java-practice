package fundamentals;

public class Matrix {
	
	/**
	 * given a 2d matrix of int, find the position i,j that has the highest sum of
	 * it's neighbors, not counting diagonal neighbors, and wrapping around where position 
	 * is on the edge of the matrix
	 * @param matrix
	 * @return
	 */
	public static int [] findMaxSum(int [][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) {
			return new int[]{-1,-1};
		}
			
		int currentMax = 0;
		int maxI = 0, maxJ = 0;
		for(int i = 0; i < matrix[0].length; i++) {
			for(int j=0; j < matrix[i].length; j++) {
				int sum = getSumAt(matrix, i, j);
				if(sum > currentMax) {
					currentMax = sum;
					maxI = i;
					maxJ = j;
				}
			}
		}
		int [] foundPosition = new int[2];
		foundPosition[0] = maxI;
		foundPosition[1] = maxJ;
		return foundPosition;
	}
	
	//
	private static int getSumAt(int [][] matrix, int i, int j){
		int sum = 0;
		
		//value at top
		if(i == 0) {
			sum += matrix[matrix.length-1][j];
		} else {
			sum += matrix[i - 1][j];
		}
		
		//value at bottom
		if(i == matrix.length - 1) {
			sum += matrix[0][j];
		} else {
			sum += matrix[i + 1][j];
		}
		
		//value at left
		if(j == 0) {
			sum += matrix[0][matrix[0].length - 1];
		} else {
			sum += matrix[i][j - 1];
		}
		
		//value at right
		if(j == matrix[0].length - 1) {
			sum += matrix[i][0];
		} else {
			sum += matrix[i][j + 1];
		}
		
		return sum;
	}
	
}
