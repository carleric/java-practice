package fundamentals;

public class Node {
	Node next = null;
	public int data;
	
	public Node(int d){
		data = d;
	}
	
	public void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		while (n.next != null){
			n = n.next;
		}
		n.next = end;
	}
	
	public void appendToTail(Node n){
		Node current = this;
		while(current.next != null){
			current = current.next;
		}
		current.next = n;
	}
	
	public int valueAt(int index){
		Node node = this;
		int i = 0;
		if(index == 0 && node != null)
			return node.data;
		else{
			while(node.next != null){
				node = node.next;
				i++;
				if(i == index)
					return node.data;
			}
			return -1;
		}
	}
	
	public int length(){
		Node node = this;
		int count = 0;
		while(node != null){
			count++;
			node = node.next;
		}
		return count;
	}
}
