package structures.trees;

public class BinarySearchTree extends BinaryTree {
	private int size = 0;

	public BinarySearchTree(Comparable rootData) {
		super(rootData);
		size++;
	}
	
	public BinarySearchTree() {
		super();
	}
	
	/**
     * 
     * @param x the item to insert.
     */
    public void insert( Comparable x )
    {
        this.root = insert( x, this.root );
        size ++;
    }
    
    public int count(){
    	return size;
    }
    
    public void displayValuesInOrder(){
    	super.inOrderVisit();
    }
    
    public BinarySearchTree clone(){
    	BinarySearchTree t = new BinarySearchTree();
    	preOrderClone(this.root, t);
    	return t;
    }
    
    private void preOrderClone(BinaryNode n, BinarySearchTree t){
    	if(n == null)
    		return;
    	t.insert(n.data);
    	preOrderClone(n.left, t);
    	preOrderClone(n.right, t);
    }
    
    /**
     * Internal method to get element field.
     * @param t the node.
     * @return the element field or null if t is null.
     */
    private Comparable elementAt( BinaryNode t )
    {
        return t == null ? null : t.data;
    }
    
    public BinaryNode find( Comparable x ){
    	return this.find(root, x);
    }
    
    private BinaryNode find(BinaryNode current, Comparable x){
    	if(current.data.compareTo(x) == 0)
    		return current;
    	else if(current.data.compareTo(x) > 0)
    		return find(current.left, x);
    	else
    		return find(current.right, x);
    }
    
    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public Comparable findMin( )
    {
        return elementAt( findMin( root ) );
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public Comparable findMax( )
    {
        return elementAt( findMax( root ) );
    }
	
    private BinaryNode insert( Comparable x, BinaryNode t )
    {
/* 1*/      if( t == null )
/* 2*/          t = new BinaryNode( x, null, null );
/* 3*/      else if( x.compareTo( t.data ) < 0 )
/* 4*/          t.left = insert( x, t.left );
/* 5*/      else if( x.compareTo( t.data ) > 0 )
/* 6*/          t.right = insert( x, t.right );
/* 7*/      else
/* 8*/          ;  // Duplicate; do nothing
/* 9*/      return t;
    }
    
    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    private BinaryNode findMin( BinaryNode t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode findMax( BinaryNode t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }
    
    public int countLessThan(int x){
    	return countLessThan(x, this.root);
    }
    
    private int countLessThan(int x, BinaryNode t){
    	int count = t.data.compareTo(new Integer(x)) < 0 ? 1 : 0;
    	
    	if(t.left != null && t.right != null)
    		return count + countLessThan(x, t.left) + countLessThan(x, t.right);
    	else if(t.left != null && t.right == null)
    		return count + countLessThan(x, t.left);
    	else if(t.left == null && t.right != null)
    		return count + countLessThan(x, t.right);
    	else
    		return count;
    }
    
    

}
