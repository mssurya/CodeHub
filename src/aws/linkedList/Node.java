package aws.linkedList;

public class Node {
	private Node nextNode;
	private int data;
	
	public Node(int data) {
		this.data=data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Data: " + this.data;
	}
	

}
