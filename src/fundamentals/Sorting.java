package fundamentals;

public class Sorting {

	/**
	 * O(n2) average
	 */
    public void bubbleSort(int [] nums){
        boolean flag = true;
        while(flag){
            flag = false;
            for( int i=0; i<nums.length-1; i++){
                if(nums[i] > nums[i+1]){
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                    flag = true;
                }     
            }
        }
    }
    
    /**
     * O(n2) always
     */
    public void selectionSort(int [] nums){
    	for(int i =0; i<nums.length; i++){
    		int swap = -1;
    		int smallest = nums[i];
    		//locate smallest element between positions 1 and i
    		for(int j=i+1; j<nums.length; j++){
    			if(nums[j] < smallest){
    				smallest = nums[j];
    				swap = j;
    			}
    		}
    		//swap smallest found with element at i
    		if(swap >= 0){
    			int tmp = nums[i];
    			nums[i] = nums[swap];
    			nums[swap] = tmp;
    		}
    	}
    }
    
    /**
     * O(nLog(n)) avg- worst
     * @param nums
     * @param low
     * @param high
     */
    public void mergeSort(int [] nums, int low, int high){
    	if(low < high){
    		int middle = (low + high) / 2;
    		mergeSort(nums, low, middle); //left half
    		mergeSort(nums, middle + 1, high); //right half
    		merge(nums, low, middle, high); //merge
    	}
    }
    
    private void merge(int [] nums, int low, int middle, int high){
    	int [] helper = new int[nums.length];
    	
    	for(int i=low; i<=high; i++){
    		helper[i] = nums[i];
    	}
    	
    	int helperLeft = low;
    	int helperRight = middle + 1;
    	int current = low;
    	
    	//iterate through helper array, compare left and right half
    	//copying back the smaller element from the two halves into 
    	//the original array
    	while (helperLeft <= middle && helperRight <= high){
    		if (helper[helperLeft] <= helper[helperRight])
    		{
    			nums[current] = helper[helperLeft];
    			helperLeft++;
    		}
    		else{
    			nums[current] = helper[helperRight];
    			helperRight++;
    		}
    		current++;
    	}
    	
    	int remaining = middle - helperLeft;
    	for (int i=0; i<=remaining; i++){
    		nums[current+i] = helper[helperLeft + i];
    	}
    }
    
    /**
     * O(n Log(n)) avg - worst case O (n2)
     * 
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort(int [] nums, int left , int right){
    	int index = partition(nums, left, right);
    	if(left < index -1){//sort left half
    		quickSort(nums, left, index-1);
    	}
    	if(index < right){//sort right half
    		quickSort(nums, index, right);
    	}
    }
    
    private int partition(int [] nums, int left, int right){
    	int pivot = nums[(left + right)/2]; //pick pivot point
    	while (left <= right){
    		while (nums[left] < pivot) left++;
    		
    		while (nums[right] > pivot) right--;
    		
    		if(left <= right){
    			int tmp = nums[left];
    			nums[left] = nums[right];
    			nums[right] = tmp;
    			left++;
    			right--;
    		}
    	}
    	return left;
    }
}
