package Problem2;

public class MyStringLinkedList {
	Node header;

	MyStringLinkedList() {
		header = null;
	}

	public void addFront(String item) {
		if (header == null)
			header = new Node(null, item, null);
		else {
			Node n = new Node(null, item, header);
			header.previous = n;
			header = n;
		}
	}

	public void addLast(String item) {
		if (header == null)
			header = new Node(null, item, null);
		else {

			Node last = findLast();
			last.next = new Node(last, item, null);
		}
	}

	public void preAddNode(Node n, String value) {
		Node newNode;
		if (n == null) {
			// List is empty
			newNode = new Node(null, value, null);
		} else if (n.previous == null) {
			// n is the first node
			addFront(value);
		} else {
			newNode = new Node(n.previous, value, n);
			n.previous.next = newNode;
			n.previous = newNode;
		}

	}

	public void postAddNode(Node n, String value) {
		Node newNode;
		if (n == null) {
			// List is empty
			newNode = new Node(null, value, null);
		} else if (n.next == null) {
			// n is the last node
			addLast(value);
		} else {
			newNode = new Node(n, value, n.next);
			n.next.previous = newNode;
			n.next = newNode;
		}

	}

	public int size() {
		int count = 0;
		if (header == null)
			return 0;
		else {
			Node temp = header;
			while (temp != null) {
				count++;
				temp = temp.next;
			}
		}
		return count;
	}

	public boolean isEmpty() {
		if (header == null)
			return true;
		else
			return false;
	}

	// implement code
	public Node getFirst() {
		return header;
	}

	// implement code
	public Node getLast() {
		return this.findLast();
	}

	// implement code
	public void removeFirst() {
	    if (header != null) {
			header.next.previous = null;
			header = header.next;
		}
	    else
	    	System.out.println("List is empty");
	}

	// implement code
	public void removeLast() {
		Node temp = this.findLast();
		if(temp==null){
			System.out.println("Can't delete");
		}
		else
		{
		temp.previous.next = null;
		temp.previous = null;
		}
	}

	// implement code
	public void printMin() {
		Node min = header;
		if (header != null) {
			Node temp = header;
			while (temp != null) {
				if (temp.toString().compareTo(min.toString()) <= 1) {
					min = temp;
				}
				temp = temp.next;
			}
		}
		System.out.println(min);
	}

	// implement code
	public void printMax() {
		Node max = header;
		if (header != null) {
			Node temp = header;
			while (temp != null) {
				if (temp.toString().compareTo(max.toString()) >= 1) {
					max = temp;
				}
				temp = temp.next;
			}
		}
		System.out.println(max);
	}

	public Node findItem(String str) {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp != null)
				if (str.equals(temp.value))
					return temp;
				else
					temp = temp.next;
			return null;
		}
	}

	public String findFirst() {
		if (header == null)
			return null;
		else {
			Node temp = header;
			return temp.value;
		}
	}

	public void deleteNode(Node n) {
		if (header != null && n != null) {
			if (n.next == null && n.previous == null) {
				// only one node
				header = null;
				n = null;
				System.out.println("Header Removed");

			} else if (n.previous == null) {
				// remove first node
				n.next.previous = n.previous;
				header = n.next;
				n = null;
				System.out.println("First node Removed");
			} else if (n.next == null) {
				// remove last node
				n.previous.next = n.next;
				n = null;
				System.out.println("Last Node Removed");
			} else {
				// general case
				n.next.previous = n.previous;
				n.previous.next = n.next;
				n = null;
				System.out.println("Given node is deleted");
			}
		}

	}

	public String toString() {
		String str = "";
		Node temp = header;
		while (temp != null) {
			str = str + "-->[" + temp.value.toString() + "]";
			temp = temp.next;
		}
		str = str + "-->[" + "NULL" + "]";
		return str;
	}

	public Node findLast() {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp.next != null)
				temp = temp.next;
			return temp;
		}
	}

	class Node {
		String value;
		Node next;
		Node previous;

		Node(Node previous, String value, Node next) {
			this.previous = previous;
			this.value = value;
			this.next = next;
		}

		public String toString() {
			return value;
		}
	}

	public static void main(String[] args) {
		MyStringLinkedList mySL = new MyStringLinkedList();
		System.out.println(mySL);

		mySL.addFront("Carrot Cake");
		System.out.println(mySL);

		mySL.addFront("Blueberry Muffin");
		System.out.println(mySL);

		mySL.addFront("Apple Pie");
		System.out.println(mySL);

		mySL.deleteNode(mySL.findItem("Apple Pie"));
		System.out.println(mySL);

		mySL.deleteNode(mySL.findItem("Carrot Cake"));
		System.out.println(mySL);

		mySL.preAddNode(mySL.findItem("Blueberry Muffin"), "Apple Pie");
		System.out.println(mySL);

		mySL.preAddNode(mySL.findItem("Apple Pie"), "Mango Smoothie");
		System.out.println(mySL);

		System.out.println("First Node : " + mySL.findFirst());

	}

}
/*Output
 * -->[NULL]
-->[Carrot Cake]-->[NULL]
-->[Blueberry Muffin]-->[Carrot Cake]-->[NULL]
-->[Apple Pie]-->[Blueberry Muffin]-->[Carrot Cake]-->[NULL]
First node Removed
-->[Blueberry Muffin]-->[Carrot Cake]-->[NULL]
Last Node Removed
-->[Blueberry Muffin]-->[NULL]
-->[Apple Pie]-->[Blueberry Muffin]-->[NULL]
-->[Mango Smoothie]-->[Apple Pie]-->[Blueberry Muffin]-->[NULL]
First Node : Mango Smoothie
*/
