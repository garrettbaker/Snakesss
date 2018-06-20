import java.util.Observable;

public class SnakeGame extends Observable {

	char[][] board;
	private int size;
	Snake snake1; //, snake2;
	int maxLength;
	boolean running;

	public SnakeGame(int boardSize) {

		// initialize size and players
		size = boardSize;
		
		//spawn snake in middle going right
		snake1 = new Snake(new Node(size/2, size/2), 'r');
		//snake2 = new Snake(new Node(size-1, size/2), 'l');
		
		maxLength = 4;

		// initialize empty board
		board = new char[size][size];
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				board[r][c] = '0';
			}
		}

		// Add snakes to board
		board[snake1.head.getX()][snake1.head.getY()] = '1';
		//board[snake2.head.getX()][snake2.head.getY()] = '2';

		running = true;
		
		setChanged();
		notifyObservers();
	}

	// Changes the direction stored in Snake class
	public void changeDir(char dir) {
		snake1.direction = dir;
	}

	// Moves each player in their stored direction
	public void makeMove() {
		// Add head node to Snake
		if (snake1.direction == 'r') {
			snake1.addNode(new Node(snake1.head.getX()+1, snake1.head.getY()));
		} else if (snake1.direction == 'l') {
			snake1.addNode(new Node(snake1.head.getX()-1, snake1.head.getY()));
		} else if (snake1.direction == 'u') {
			snake1.addNode(new Node(snake1.head.getX(), snake1.head.getY()+1));
		} else if (snake1.direction == 'd') {
			snake1.addNode(new Node(snake1.head.getX(), snake1.head.getY()-1));
		}
		
		// Check board boundary
		if (snake1.head.getX() >= size || snake1.head.getY() >= size) {
			lose();
			return;
		}
		
		// check for food or eating self
		if (board[snake1.head.getX()][snake1.head.getY()] == 'f') {
			eat();
		} else if (board[snake1.head.getX()][snake1.head.getY()] != '0') {
			lose();
			return;
		}
		
		// Update board - '1' for snake1
		board[snake1.head.getX()][snake1.head.getY()] = '1';
		
		if (snake1.length > maxLength)
			snake1.removeTail();
	}
	
	private void lose() {
		running = false;
	}

	// snakes get longer
	public void eat() {
		maxLength++;
	}
	
	public String toString() {
		
		String str = "";
		for (int i = 0; i<size; i++) {
			for (int j=0;j<size; j++) {
				if (board[i][j] != '0')
					str += board[i][j];
				str += "\t";
			}
			str += '\n';
		}
		return str;
	}
}
