package structures;

import java.util.Hashtable;

public class LinkedList {
	public Node root = null;

	public LinkedList(int d){
		this.root = new Node(d);
	}

	public void appendToTail(int d){
		Node end = new Node(d);
		Node n = this.root;
		while (n.next != null){
			n = n.next;
		}
		n.next = end;
	}

	public void appendToTail(Node n){
		Node current = this.root;
		while(current.next != null){
			current = current.next;
		}
		current.next = n;
	}

	public void appendToTail(LinkedList list){
		Node current = this.root;
		while(current.next != null){
			current = current.next;
		}
		current.next = list.root;
	}

	public int valueAt(int index){
		Node node = this.root;
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
		Node node = this.root;
		int count = 0;
		while(node != null){
			count++;
			node = node.next;
		}
		return count;
	}

	/**
	 * O (n)
	 */
	public void removeDuplicates(){
		Hashtable hash = new Hashtable();
		Node current = this.root;
		Node prev = null;
		while(current != null){
			if(hash.containsKey(current.data)){
				prev.next = current.next;
			}else{
				hash.put(current.data, true);
				prev = current;
			}
			current = current.next;
		}
	}

	public void removeDuplicatesNoBuffer(){
		Node current = this.root;

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

	public Node findKthLastElement(int k){
		Node current = this.root;
		Node Kth = current;
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

	public LinkedList insertOrdered(int x){
		Node current = this.root;
		LinkedList lesser = null;
		LinkedList greater = null;
		while(current != null){
			if(current.data >= x){
				if(greater == null){
					greater = new LinkedList(current.data);
				}else{
					greater.appendToTail(current.data);
				}
			}else{
				if(lesser == null){
					lesser = new LinkedList(current.data);
				}else{
					lesser.appendToTail(current.data);
				}
			}
			current = current.next;
		}
		lesser.appendToTail(x);
		lesser.appendToTail(greater);
                return lesser;
	}

//	public LinkedList addNumbers(LinkedList listB){
//		Node sum = null;
//		int remainder = 0;
//                Node a = this.root;
//                Node b = listB.root;
//		while(a != null && b != null){
//			Node n = new Node(a.data + b.data + remainder);
//			if(n.data > 9){
//				remainder = 10 - n.data;
//				n.data = 1;
//			}else{
//				remainder = 0;
//			}
//			if(sum != null)
//				this.appendToTail(n);
//			else{
//				sum = n;
//			}
//
//			a = a.next;
//			b = b.next;
//		}
//		if(a != null && b == null){
//			while(a != null){
//				Node n = new Node(a.data + remainder);
//				if(n.data > 9){
//					remainder = 10 - n.data;
//					n.data = 1;
//				}
//				if(sum != null)
//					this.appendToTail(n);
//				else{
//					sum = n;
//				}
//				a = a.next;
//			}
//		}else if(a == null && b != null){
//			while(b != null){
//				Node n = new Node(b.data + remainder);
//				if(n.data > 9){
//					remainder = 10 - n.data;
//					n.data = 1;
//				}
//				if(sum != null)
//					this.appendToTail(n);
//				else{
//					sum = n;
//				}
//				b = b.next;
//			}
//		}
//		return sum;
//	}
}
