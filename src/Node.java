public class Node {

	private int x;
	private int y;
	private Node next;
	private Node prev;

	public Node(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setNext(null);
		this.setPrev(null);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

}