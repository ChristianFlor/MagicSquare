package ui;
import model.MagicSquare;
import customExceptions.IllegalSizeException;
import customExceptions.UncompatibleValuesException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MagicSquareController {

	@FXML
	private TextField sizeTF;

	@FXML
	private Label msg;

	@FXML
	private MenuButton startMB;

	@FXML
	private MenuItem startMB1;

	@FXML
	private MenuItem startMB2;

	@FXML
	private MenuItem startMB3;

	@FXML
	private MenuItem startMB4;

	@FXML
	private MenuButton directMB;

	@FXML
	private MenuItem directMB1;

	@FXML
	private MenuItem directMB2;

	@FXML
	private MenuItem directMB3;

	@FXML
	private MenuItem directMB4;

	@FXML
	private ScrollPane matrixSP;

	private GridPane matrixGP;

	private MagicSquare program;

	private Label resultH;

	private Label resultV;
	/**
	 * This method makes the other button visible to select the direction and <br>
	 * disables some options of the directions depending on what you have chosen.<br>
	 * @param event
	 */
	@FXML
	public void EAST(ActionEvent event) {
		this.directMB.setVisible(true);
		this.startMB.setText("EAST");

		this.directMB1.setDisable(true);
		this.directMB3.setDisable(true);
	}
	/**
	 * This method makes the other button visible to select the direction and <br>
	 * disables some options of the directions depending on what you have chosen.<br>
	 * @param event
	 */
	@FXML
	public void NORTH(ActionEvent event) {
		this.directMB.setVisible(true);
		this.startMB.setText("NORTH");

		this.directMB3.setDisable(true);
		this.directMB4.setDisable(true);
	}

	/**
	 * This method makes the other button visible to select the direction and <br>
	 * disables some options of the directions depending on what you have chosen.<br>
	 * @param event
	 */
	@FXML
	public void SOUTH(ActionEvent event) {
		this.directMB.setVisible(true);
		this.startMB.setText("SOUTH");

		this.directMB1.setDisable(true);
		this.directMB2.setDisable(true);
	}
	/**
	 * This method makes the other button visible to select the direction and <br>
	 * disables some options of the directions depending on what you have chosen.<br>
	 * @param event
	 */
	@FXML
	public void WEST(ActionEvent event) {
		this.directMB.setVisible(true);
		this.startMB.setText("WEST");

		this.directMB2.setDisable(true);
		this.directMB4.setDisable(true);
	}
	/**
	 * This method select the address so that later we can use it
	 * @param event
	 */
	@FXML
	public void NORTHEAST(ActionEvent event) {
		this.directMB.setText("NORTHEAST");
	}
	/**
	 * This method select the address so that later we can use it
	 * @param event
	 */
	@FXML
	public void NORTHWEST(ActionEvent event) {
		this.directMB.setText("NORTHWEST");
	}
	/**
	 * This method select the address so that later we can use it
	 * @param event
	 */
	@FXML
	public void SOUTHEAST(ActionEvent event) {
		this.directMB.setText("SOUTHEAST");
	}
	/**
	 * This method select the address so that later we can use it
	 * @param event
	 */
	@FXML
	public void SOUTHWEST(ActionEvent event) {
		this.directMB.setText("SOUTHWEST");
	}

	/**
	 * This method clears all the boxes that have been marked
	 * @param event
	 */
	@FXML
	public void clear(ActionEvent event) {
		this.directMB1.setDisable(false);
		this.directMB2.setDisable(false);
		this.directMB3.setDisable(false);
		this.directMB4.setDisable(false);

		this.sizeTF.setText("");
		this.msg.setText("");

		this.startMB1.setDisable(false);
		this.startMB1.setDisable(false);
		this.startMB1.setDisable(false);
		this.startMB1.setDisable(false);

		this.startMB.setText("StartPoint");
		this.directMB.setText("Direction");

		matrixSP.setContent(null);
	}
	/**
	* This method is called when the << Generate >> button is clicked on the user interface.<br>
	* Makes the ScrollPane matrix visible<br>
	* Then proceeds to initialize a MagicSquare object with the corresponding corresponding values of<br>
	* The TextField and MenuItem controllers, if all values are correct, each cell in GridPane gets<br>
	* Filled with the integers of the corresponding MagicSquare matrix.<br>
    * <b> pre: </b>  every needed value has to be selected in the user interface before trying to generate the matrix,<br>
    * if not, clicking on Generate button will show an error message Label.<br>
    * <b> post: </b>  The GridPane will be filled up with the correspondent integers.
    * @param event it's the value that we pass as argument when we click in the <<Generate>> button.
	 * @throws UncompatibleValuesException 
    */
	@FXML
	public void generateBT(ActionEvent event) throws UncompatibleValuesException, IllegalSizeException {
		matrixSP.setVisible(true);
		matrixGP = new GridPane();

		matrixSP.setContent(matrixGP);
		msg.setText("");

		try {

			int size = Integer.parseInt(sizeTF.getText());

			String startPoint = startMB.getText();

			String direction = directMB.getText();

					this.program = new MagicSquare(startPoint, direction, size);
					this.program.generate();
	
					for (int i = 0; i < size; i++) {
						for (int j = 0; j < size; j++) {
							Button a= new Button(program.getMagicSquare()[i][j] + "");
							final int row = i;
							final int col = j;
							a.setOnMouseClicked(new EventHandler<Event>() {
								
								@Override
								public void handle(Event evt) {
									challenge(row,col);	
								}
							});
							matrixGP.add(a, j, i);
						}
					}

		}catch(IllegalSizeException e) {
			msg.setText(e.getMessage());
		}

	}
	/**
	 * This method initializes some attributes of the controlling class
	 * @param event
	 */
	@FXML
	public void initialize() {
		resultH = new Label();
		resultV = new Label();
		resultH.setStyle("-fx-background-color:#7ac3ff;");
		resultV.setStyle("-fx-background-color:#7ac3ff;");
	}	
	/**
	 * This method paints a row and column depending on what the user has chosen
	 * @param event
	 */
	public void challenge(int rowIndex, int colIndex) {
		matrixGP.getChildren().remove(resultH);
		matrixGP.getChildren().remove(resultV);
			if(colIndex < program.getMagicSquare().length && rowIndex < program.getSize()) {
				for(int i = 0; i < program.getMagicSquare().length; i++ ) {
					for(int j = 0; j < program.getMagicSquare().length; j++) {
						if(j == colIndex) {
							matrixGP.getChildren().get(i*program.getMagicSquare().length+j).
							setStyle("-fx-background-color:#22e52f;");
						}else {
							if(i != rowIndex) {
								matrixGP.getChildren().get(i*program.getMagicSquare().length+j).
								setStyle("-fx-background-color:#ffffff");
							}
						}
						if(i == rowIndex) {
							matrixGP.getChildren().get(i*program.getMagicSquare().length+j).
							setStyle("-fx-background-color:#22e52f;");
						}else {
							if(j != colIndex) {
								matrixGP.getChildren().get(i*program.getMagicSquare().length+j).
								setStyle("-fx-background-color:#ffffff;");    	    					
							}
						}
					}
				}
				resultV.setText(" = " + program.magicConstant());
				resultH.setText(" = " + program.magicConstant());
				matrixGP.add(resultH, program.getMagicSquare().length, rowIndex);
				matrixGP.add(resultV, colIndex, program.getMagicSquare().length);
			}
	}
}