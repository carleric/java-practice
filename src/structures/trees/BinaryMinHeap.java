package structures.trees;

public class BinaryMinHeap {
	private Comparable [] data;
	private int size;
	private static final int MAX_SIZE = 100;
	
	public BinaryMinHeap(int size){
		data = new Comparable[MAX_SIZE];
		this.size = 0;
	}

	private int getLeftIndex(int pos) {
		return 2 * pos + 1;
	}

	private int getRightIndex(int pos) {
		return 2 * pos + 2;
	}

	private int getParentIndex(int pos) {
		return (pos - 1) / 2;
	}

	public class HeapException extends RuntimeException {
		public HeapException(String message) {
			super(message);
		}
	}
	
	/**
	 * inserts the Comparable parameter at the tail of the 
	 * buffer, then bubbleUp starting at the tail to allow 
	 * the new element to rise to a position where it is less 
	 * than its children and greater than it's parent
	 * @param x
	 */
	public void insert(Comparable x)
	{
		if(size == data.length) 
			throw new HeapException("out of space");

		//Insert a new item to the end of the array
		int pos = size;
		data[pos] = x;
		size ++;
		
		bubbleUp(pos);
	}
	
	/**
	 * pop the root element, 
	 * then swap the tail element with root
	 * then bubbleDown the root element
	 * @return minimum Comparable element
	 */
	public Comparable popMin(){
		Comparable min = null;
		if(size > 0){
			min = data[0];
			data[0] = data[size-1];
			data[size-1] = null;
			size --;
			bubbleDown(0);
		}
		return min;
	}
	
	/**
	 * called initially on tail element after an insertion
	 * allows values that are less than their parents to be 
	 * swapped with their parents and 'bubble up'
	 */
	private void bubbleUp(int pos){
		Comparable parent = data[getParentIndex(pos)];
		//if less than parent
		if(data[pos].compareTo(parent) < 0){
			swap(pos, getParentIndex(pos));
			bubbleUp(getParentIndex(pos));
		}
	}
	
	/**
	 * called after a pop of the root element
	 * the tail is swapped with the root, then allowed to bubble down
	 * if it is greater than it's children.  swapping is performed with the lesser
	 * of the children to allow the new minimum to be swapped up.
	 */
	private void bubbleDown(int pos){
		//swap with smaller of children
		int smallerIndex = -1;
		//if left is less than right
		if(getLeftIndex(pos) < size && data[getLeftIndex(pos)].compareTo(data[getRightIndex(pos)]) < 0){
			smallerIndex = getLeftIndex(pos);
		}else if(getRightIndex(pos) < size){
			smallerIndex = getRightIndex(pos);
		}
		//if smaller child is less than this, swap it
		if(smallerIndex > -1 && (data[smallerIndex].compareTo(data[pos]) < 0)){
			swap(pos, smallerIndex);
			bubbleDown(smallerIndex);
		}
	}

	private void swap(int posA, int posB){
		Comparable tmp = data[posA];
		data[posA] =  data[posB];
		data[posB] =  tmp;
	}

}
