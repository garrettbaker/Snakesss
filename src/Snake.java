
public class Snake {

	Node head;
	Node tail;
	char direction;
	int length;
	
	public Snake(Node node, char direction) {
		head = node;
		tail = node;
		this.direction = direction;
		length = 1;
	}
	
	// Add node in front of Snake, increase length
	void addNode(Node newHead){
		newHead.setNext(head);
		head.setPrev(newHead);
		head = newHead;
		length++;
	}

	// Remove tail, decrease length 
	void removeTail() {
		tail = tail.getPrev();
		tail.setNext(null);
		length--;
	}
}