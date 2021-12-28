package aws.linkedList;

public class LinkedList {
	private Node head;

	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		newNode.setNextNode(this.head);
		this.head = newNode;
	}

	@Override
	public String toString() {
		String result = "{";
		Node current = this.head;

		while (current != null) {
			result += current.toString() + ",";
			current = current.getNextNode();
		}
		result += "}";
		return result;
	}

	public int length() {
		int length = 0;
		Node current = this.head;
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
	}

	public void deleteFromHead() {
		this.head = this.head.getNextNode();
	}
	
	public Node find(int data) {
		Node current = this.head;
		while(current !=null) {
			if(current.getData()==data) {
				return current;
			}
			current =current.getNextNode();
		}
		return null;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertAtHead(5);
		list.insertAtHead(20);
		list.insertAtHead(2);
		list.insertAtHead(12);
		list.insertAtHead(19);
		list.insertAtHead(20);

		list.deleteFromHead();

		System.out.println(list);
		System.out.println("Length: " + list.length());
		System.out.println("Found: " + list.find(20));
	}

}
