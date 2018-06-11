import java.util.Observable;

public class SnakeGame extends Observable {

	char[][] board;
	private int size;
	Snake snake1, snake2;
	int maxLength;

	public SnakeGame(int size) {

		// initialize size and players
		this.size = size;
		snake1 = new Snake(new Node(0, size/2), 'r');
		snake2 = new Snake(new Node(size-1, size/2), 'l');
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
		board[snake2.head.getX()][snake2.head.getY()] = '2';
		
		setChanged();
		notifyObservers();
	}

	// Changes the direction stored in Snake class
	public void changeDir(int player, char dir) {
		if (player == 1)
			snake1.direction = dir;
		else
			snake2.direction = dir;
	}

	// Moves each player in their stored direction
	public void makeMove() {
		
	}
}
