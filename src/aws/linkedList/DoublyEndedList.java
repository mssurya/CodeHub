package aws.linkedList;

public class DoublyEndedList {
	Node head;
	Node tail;

	public void insertAtTail(int data) {
		Node newNode = new Node(data);
		if (this.head == null) {
			this.head = newNode;
		}

		if (this.tail != null) {
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
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

	public static void main(String[] args) {
		DoublyEndedList endedList = new DoublyEndedList();
		endedList.insertAtTail(10);
		endedList.insertAtTail(15);
		endedList.insertAtTail(11);
		endedList.insertAtTail(9);
		endedList.insertAtTail(5);
		endedList.insertAtTail(3);

		System.out.println(endedList);
	}

}
