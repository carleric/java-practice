package test;
import structures.trees.BinaryMinHeap;
import structures.trees.BinarySearchTree;
import junit.framework.TestCase;


public class BinaryTreeTests extends TestCase {
	private BinarySearchTree bst;
	
	public void setUp(){
		bst = new BinarySearchTree(new Integer(3));
		bst.insert(new Integer(6));
		bst.insert(new Integer(23));
		bst.insert(new Integer(50));
		bst.insert(new Integer(1));
		bst.insert(new Integer(39));
		bst.insert(new Integer(44));
	}
	
	public void testClone(){
		BinarySearchTree t = bst.clone();
		System.out.println("bst original preorder:");
		bst.preOrderVisit();
		System.out.println("bst clone preorder:");
		t.preOrderVisit();
		System.out.println();
		
		assertTrue(t.count() == 7);
		assertTrue(t.findMin().compareTo(new Integer(1)) == 0);
		assertTrue(t.findMax().compareTo(new Integer(50)) == 0);
	}
	
	public void testPreOrderVisit(){
		bst.preOrderVisit();
		System.out.println();
		bst.preOrderNonRecursive();
		System.out.println();
	}
	
	public void testInOrderVisit(){
		bst.inOrderVisit();
		System.out.println();
	}
	
	public void testPostOrderVisit(){
		bst.postOrderVisit();
		System.out.println();
	}
	
	public void testLevelOrderVisit(){
		bst.levelOrderVisit();
		System.out.println();
	}
	
	public void testFind(){
		assertTrue(bst.find(23).data.compareTo(new Integer(23)) == 0);
	}
	
	public void testMinBinaryHeap(){
		BinaryMinHeap bmh = new BinaryMinHeap(6);
		bmh.insert(new Integer(3));
		bmh.insert(new Integer(7));
		bmh.insert(new Integer(85));
		bmh.insert(new Integer(8));
		bmh.insert(new Integer(10));
		bmh.insert(new Integer(1));
		Integer c = (Integer)bmh.popMin();
		assertTrue(c.intValue() == 1);
	}
	
	public void testCountLessThan(){
		int cnt = bst.countLessThan(39);
		assertTrue(cnt == 4);
	}
	
}
