import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SnakeGUI extends Application implements Observer{

	public static void main(String[] args) {
		launch(args);
	}


	private SnakeGame theGame;
	private BorderPane window;
	private TextArea textArea;
	
	@Override
	public void start(Stage stage) throws Exception {

		// initialize the theGame
		int size = 10;
		theGame = new SnakeGame(size);
		window = new BorderPane();
		Scene scene = new Scene(window, size, size);

		// add this to the Game's list of Observers
		theGame.addObserver(this);
		
		// add listener to the keyboard
		scene.setOnKeyPressed(new KeyboardListener());
		
		// create the actual stuff we see
		
		textArea = new TextArea();
	    textArea.setPrefColumnCount(size);
	    textArea.setPrefRowCount(size);
	    textArea.setFont(new Font("courier", 32));
	    textArea.setText(theGame.toString());
	    textArea.setMinHeight(400);
	    textArea.setMaxHeight(400);
	    
	    
		window.setCenter(textArea);
		stage.setScene(scene);
	    stage.show();
	}

	private class KeyboardListener implements EventHandler<KeyEvent> {

		@Override
		public void handle(KeyEvent e) {

			if (e.getCode() == KeyCode.RIGHT) {
				System.out.println("Pressed R!");
			}
			if (e.getCode() == KeyCode.LEFT) {
				System.out.println("Pressed L!");
			}
			if (e.getCode() == KeyCode.UP) {
				System.out.println("Pressed U!");
			}
			if (e.getCode() == KeyCode.DOWN) {
				System.out.println("Pressed D!");
			}

		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
