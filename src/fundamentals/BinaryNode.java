package fundamentals;

public class BinaryNode {
	public BinaryNode right;
	public BinaryNode left;
	public Comparable data;
	
	public BinaryNode(Comparable data){
		this.data = data;
	}
	
	public BinaryNode(Comparable data, BinaryNode left, BinaryNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	
}
