package fundamentals;
import java.util.Hashtable;


public class LinkedLists {

	/**
	 * O (n)
	 */
	public void removeDuplicates(Node list){
		Hashtable hash = new Hashtable();
		Node prev = null;
		while(list != null){
			if(hash.containsKey(list.data)){
				prev.next = list.next;
			}else{
				hash.put(list.data, true);
				prev = list;
			}
			list = list.next;
		}
	}
	
	public void removeDuplicatesNoBuffer(Node list){
		Node current = list;
	
		while(current != null){
			Node runner = current;
			while(runner.next != null){
				if(runner.next.data == current.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	public Node findKthLastElement(Node list, int k){
		Node current = list;
		Node Kth = list;
		int i = 0;
		while(current.next != null){
			if(i == k){
				Kth = current;
			}else if(i > k){
				Kth = Kth.next;
			}
			current = current.next;
			i++;
		}
		return Kth;
	}
	
	public void removeNode(Node n){
		if(n.next != null){
			n.data = n.next.data;
			n.next = n.next.next;
		}
	}
	
	public Node insertOrdered(Node list, int x){
		Node lesser = null;
		Node greater = null;
		while(list != null){
			if(list.data >= x){
				if(greater == null){
					greater = new Node(list.data);
				}else{
					greater.appendToTail(list.data);
				}
			}else{
				if(lesser == null){
					lesser = new Node(list.data);
				}else{
					lesser.appendToTail(list.data);
				}
			}
			list = list.next;
		}
		lesser.appendToTail(x);
		lesser.appendToTail(greater);
		return lesser;
	}
	
	public Node addReversedNumbers(Node a, Node b){
		Node sum = null;
		int remainder = 0;
		while(a != null && b != null){
			Node n = new Node(a.data + b.data + remainder);
			if(n.data > 9){
				remainder = 10 - n.data;
				n.data = 1;
			}else{
				remainder = 0;
			}
			if(sum != null)
				sum.appendToTail(n);
			else{
				sum = n;
			}
			
			a = a.next;
			b = b.next;
		}
		if(a != null && b == null){
			while(a != null){
				Node n = new Node(a.data + remainder);
				if(n.data > 9){
					remainder = 10 - n.data;
					n.data = 1;
				}
				if(sum != null)
					sum.appendToTail(n);
				else{
					sum = n;
				}
				a = a.next;
			}
		}else if(a == null && b != null){
			while(b != null){
				Node n = new Node(b.data + remainder);
				if(n.data > 9){
					remainder = 10 - n.data;
					n.data = 1;
				}
				if(sum != null)
					sum.appendToTail(n);
				else{
					sum = n;
				}
				b = b.next;
			}
		}
		return sum;
	}
}
