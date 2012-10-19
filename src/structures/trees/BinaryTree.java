package structures.trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {
	protected BinaryNode root;
	protected int size;
	
	public BinaryTree() {
		root = null;
		size = 0;
	}
	
	public BinaryTree(Comparable rootData){
		root = new BinaryNode(rootData);
		size++;
	}
	
	private void visit(BinaryNode n){
		System.out.println(n.data.toString());
	}
	
	public void preOrderVisit(){
		System.out.println("pre-order:  ");
		preOrderVisit(this.root);
	}
	
	private void preOrderVisit(BinaryNode n){
		if(n != null){
			visit(n);
			preOrderVisit(n.left);
			preOrderVisit(n.right);
		}
	}
	
	public void inOrderVisit(){
		System.out.println("in-order:  ");
		inOrderVisit(this.root);
	}
	
	private void inOrderVisit(BinaryNode n){
		if(n != null){
			inOrderVisit(n.left);
			visit(n);
			inOrderVisit(n.right);
		}
	}
	
	public void postOrderVisit(){
		System.out.println("post-order:  ");
		postOrderVisit(this.root);
	}
	
	private void postOrderVisit(BinaryNode n){
		if(n != null){
			postOrderVisit(n.left);
			postOrderVisit(n.right);
			visit(n);
		}
	}
	
	public void levelOrderVisit(){
		System.out.println("level-order:  ");
		Queue <BinaryNode> nodeQueue = new LinkedList<BinaryNode>();
		nodeQueue.offer(this.root);
		while(!nodeQueue.isEmpty()){
			BinaryNode n = nodeQueue.poll();
			visit(n);
			if(n.left != null)
				nodeQueue.offer(n.left);
			if(n.right != null)
				nodeQueue.offer(n.right);
		}
	}
	
	public void preOrderNonRecursive(){
		System.out.println("preorder-nonrecursive: ");
		Stack <BinaryNode> nodeStack = new Stack<BinaryNode>();
		nodeStack.push(this.root);
		while(!nodeStack.isEmpty()){
			BinaryNode n = nodeStack.pop();
			visit(n);
			//push right first, because we want to do it after left
			if(n.right != null)
				nodeStack.push(n.right);
			//push left second, because we want it to pop first
			if(n.left != null)
				nodeStack.push(n.left);
		}
	}
	
	
	
}
